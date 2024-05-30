package org.choongang;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        //127.0.0.1 == localhost
        Socket socket = new Socket("127.0.0.1", 9999);
    }
}
