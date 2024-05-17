package exam01;

import java.util.TreeMap;

public class Ex01 {
    public static void main(String[] args) { //+ call stack -> main thread
        Runnable r = () -> {
          for(int i =0; i < 5; i++){
              System.out.println("thread2-"+i);

              for(long j = 0; j< 1000000000L; j++);
          }
        };

        Ex01_1 th1 = new Ex01_1(); //상속으로 생성한 스레드
        Thread th2 = new Thread(r); // runnable 인터페이스 구현

        //start(new Ex01_1());
        //start(r);

        //th1.run();
        //th2.run();
        th1.start(); // call stack 생성 + run() 메서드 실행
        th2.start(); // call stack 생성 + run() 메서드 실행
        System.out.println("program complete");
    }
    /*
    public static void start(Runnable runnable){
        Thread th = new Thread(runnable);
        th.start();
    }
    */
}

class Ex01_1 extends Thread {
    public Ex01_1() {
        super("변경된 이름1");
    }
    public void run() {
        for (int i = 0; i < 5; i++) {
            //System.out.println("thread1-"+ i);
            System.out.println(getName() + "-" + i);
            for(long j = 0; j< 1000000000L; j++);
        }
    }
}