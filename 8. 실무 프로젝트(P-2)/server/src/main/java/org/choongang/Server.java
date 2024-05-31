package org.choongang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Server {
    private ServerSocket serverSocket;
    private ExecutorService threadPool;
    private ObjectMapper om;
    private Map<String, Socket> clients; //접속한 사용자(소켓)

    public Server() {
        try { //지정한 포트가 사용 중일 때 환경변수로 다른 포트 연결
            String _port = System.getenv("port");
            int port = _port == null || _port.isBlank() ? 9999 : Integer.parseInt(_port);
            serverSocket = new ServerSocket(9999); //
        } catch (IOException e) {
            e.printStackTrace();
        }

        threadPool = new ThreadPoolExecutor(2, 100, 120L, TimeUnit.SECONDS, new SynchronousQueue<>(){});
        
        om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        
        clients = new HashMap<>();
    }

    public void start() {

        // 소켓 연결 상태 체크
        monitoring();

        while(true) {
            try {
                Socket socket = serverSocket.accept();

                SocketHandler handler = new SocketHandler(socket);

                //수신 처리
                handler.input(data -> {
                    SocketData sData = toObject(data);
                    String from = sData.getFrom(); //수신인
                    //최초 접속인 경우, 사용자(socket) 등록
                    if (!clients.containsKey(from)){
                     clients.put(from, socket);   
                    }
                    //전송
                    System.out.println(sData);
                    String to = sData.getTo();
                    handler.send(to, sData);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private SocketData toObject(String json) { //json 문자열->자바 객체로 바꿔줌
        SocketData data = null;
        try {
            data = om.readValue(json, SocketData.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return data;
    }
    private String toJSON(SocketData sData){ //자바 객체->json 문자열로 바꿔줌
        String data = null;
        try {
            data = om.writeValueAsString(sData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return data;
    }
    
    /**
     * socket 연결이 종료된 경우 clients에서 제거
     * 10초마다 소켓 연결상태 체크
     */
    public void monitoring() {
        Thread th = new Thread(()->{
            while(true) {
                try{
                    Thread.sleep(5000);
                } catch (InterruptedException e){}

                for(Map.Entry<String, Socket> client : clients.entrySet()) { //웹에 있는 키, 값 가져옴
                    if(client.getValue().isClosed()) {
                        clients.remove(client.getKey());
                    }
                }
            }
        });
        th.setDaemon(true);
        th.start();
    }
    class SocketHandler {
        private Socket socket;

        public SocketHandler(Socket socket) {
            this.socket = socket;
        }

        // 수신 처리
        public void input(Consumer<String> handler) {
            threadPool.execute(() -> {
                try(
                    DataInputStream dis = new DataInputStream(socket.getInputStream())) {

                    while(true) {
                        if (socket == null || socket.isClosed() || handler == null) {
                            Thread.currentThread().yield();
                            break;
                        }
                        String data = dis.readUTF();
                        handler.accept(data);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        // 전송 처리
        public void output(Socket toSocket, SocketData data) {
            if (toSocket == null || toSocket.isClosed() || data == null) {  //datatream이 닫히면 inputstream도 닫힘
                return;
            }
            threadPool.execute(() -> {
                try(
                    DataOutputStream dos = new DataOutputStream(toSocket.getOutputStream())){
                    String json = toJSON(data); //발신인 소켓
                    dos.writeUTF(json);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        /**
         * 메세지 전송
         * @param to
         *  all: 모든 접속자
         *  request_users: 모든 접속자 목록
         * @param data
         */
        public void send(String to, SocketData data) {
            data.setRegDt(LocalDateTime.now()); //전송시점
            if (to.equals("all")) { //전체 전송
                clients.values().forEach(s -> output(s, data));

            } else if (to.equals("request_users")){ //모든 접속자 목록
                to = data.getFrom(); //요청 정보는 요청한 사용자에게 반송

                String message = clients.keySet().stream().collect(Collectors.joining("||"));
                data.setMessage(message);

                Socket s = clients.get(to);
                output(s, data);

            } else if (to.equals("request_exit")) { //접속 종료
                String from = data.getFrom();
                Socket s = clients.get(from);
                if (s != null) {
                    if (!s.isClosed()) {
                        try {
                            s.close();
                        } catch (IOException e) {}
                    }
                    clients.remove(from);
                }
            } else { //특정 사용자 전송
                Socket s = clients.get(to);
                if (s != null) {
                    output(s, data);
                }
            }
        }
    }
}