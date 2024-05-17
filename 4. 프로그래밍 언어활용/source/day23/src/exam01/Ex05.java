package exam01;

import javax.swing.*;

public class Ex05 {
    public static void main(String[] args) throws InterruptedException{
        Thread th = new Thread(()->{ //runnable 인터페이스 바로 정의, 익명함수
            String message  = JOptionPane.showInputDialog("enter message");
            System.out.println(message);
        }); //thread로 분리, 멀티 스레드

        //메인 스레드
        th.start();

        for(int i = 1; i <= 10; i++){
            System.out.println(i);
            Thread.sleep(1000); //1초 지연
        }
    }
}
