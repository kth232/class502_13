package exam02;

public class Ex02 {
    public static void main(String[] args) {
        A a = new A();
        a.numAA=10; //같은 패키지 안에 있을 때 접근 가능
        a.printNum();
        a.numB = 100;
    }
}
