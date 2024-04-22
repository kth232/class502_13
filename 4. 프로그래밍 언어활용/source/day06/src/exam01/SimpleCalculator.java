package exam01;

public class SimpleCalculator extends Calculator{
    //상속 오류->추상클래스로 만들거나, 함수 구현해주면 객체 생성 가능

    public SimpleCalculator() {
        super(); //외부적으론 객체 생성 불가, 내부적으론 객체 생성됨
    }
    public int add(int num1, int num2) {
        return num1+num2; //메소드 재정의->상속->객체 생성, 인스턴스 메소드만 재정의 가능
    }
    //public void commonMethod() {} //final->메서드 재정의 불가
}
