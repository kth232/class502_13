package org.choongang;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 9999);

        //클라이언트->서버쪽으로 데이터 전송(동적 포트를 통해서)
        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        //데이터 주고 받는 것은 동시다발적으로 수행해야 함(순차적x)->스레드 사용
        dos.writeUTF("안녕하세요!");
        
    }
}
