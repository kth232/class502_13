package exam02;

public class B extends A{ //B가 A를 상속
    int numB = 20; //변수 정의 및 초기화
    public B() { // 생성자 메서드
        super(); // A클래스에 정의된 A 생성자 메서드 호출
        System.out.println("B 생성자");
    }
}
