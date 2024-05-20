package exam01;

public class Ex02 {
    public static void main(String[] args) {
        Thread th = new Thread(new Ex02_1()); //내부에서 수행
        th.start();

        for (int i = 0; i < 5; i++){
            System.out.println("main thread-" + i);
        }
    }
}

class Ex02_1 implements Runnable {

    @Override
    public void run() {
        // 실행 중인 스레드 객체?
        Thread th= Thread.currentThread();

        for (int i = 0; i < 5; i++){
            System.out.println("thread-" + i);
        }
    }
}