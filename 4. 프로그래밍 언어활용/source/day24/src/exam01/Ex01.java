package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Ex01_1 th = new Ex01_1();
        //th.run();
        th.start(); //별도의 스택이 만들어져서 독립적으로 작업 수행

        for(int i = 0; i < 5; i++){
            System.out.println("main thread-"+ i);
        }
    }
}

class Ex01_1 extends Thread { //상속을 받기 때문에 유연성이 떨어짐
    public void run() {
        for(int i =0; i < 5; i++){
            System.out.println(getName() + "-"+ i);
        }
    }
}