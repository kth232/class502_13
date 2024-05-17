package exam01;

import javax.swing.*;

public class Ex04 {
    public static void main(String[] args) throws InterruptedException{
        String message = JOptionPane.showInputDialog("enter message");
        //블로킹(Blocking)
        System.out.println(message); //\싱글 스레드: 같은 스택일 때 한 작업이 끝나야 다음 작업 실행됨

        for(int i = 1; i <= 10; i++){
            System.out.println(i);
            Thread.sleep(1000); //1sec 지연
        }
    }
}
