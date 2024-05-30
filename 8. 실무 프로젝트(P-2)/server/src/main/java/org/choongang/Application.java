package org.choongang;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Application {
    public static void  main(String[] args) throws Exception{
        Server server = new Server();
        server.start();
    }
        /*
        ServerSocket serverSocket = new ServerSocket(9999);
        //소켓: 여러명이 데이터를 주고 받을 목적으로 사용
        while(true) { //무한반복->서버는 24시간 대기
            System.out.println("server 대기 중.."); //접속할 때마다 대기
            Socket socket = serverSocket.accept(); //동적 할당
            System.out.println("client server connect: " + socket); //현재 연결된 클라이언트 소켓
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            String str = dis.readUTF();
            System.out.println("client's message: " + str);

        }
    }*/
}

