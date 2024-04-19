package exam02;

public class B extends A{ //B가 A를 상속
    int numB = 20;
    public B() { // 기본생성자 추가됨
        super(); // A클래스에 정의된 A생성자 호출
        System.out.println("B 생성자");
    }
}
