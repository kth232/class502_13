package exam01;

public abstract class Calculator {
    static int NUM = 10; //정적 상수

    public Calculator() {
        System.out.println("Calculator 생성자");
    }

    public abstract int add(int num1, int num2);
    //추상클래스: 수행할 코드가 없는 불완전한 클래스->객체화 불가

    public final void commonMethod() {
        //공통 자원(공통적으로 공유할 자원) 정의 가능
    }
}
