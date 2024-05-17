package exam01;

public class Ex02 {
    public static void main(String[] args) {
        Ex02_1 th1 = new Ex02_1();
        //th1.start(); //스택 분리됨->독립적인 호출 스택
        th1.run(); //main 가장 먼저 호출
    }
}

class Ex02_1 extends Thread{
    public void run() { //1번 호출
        throwException(); //2번 호출
    }

    private void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
