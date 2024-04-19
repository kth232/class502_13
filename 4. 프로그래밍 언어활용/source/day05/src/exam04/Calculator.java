package exam04;

public abstract class Calculator { //추상 클래스
    int num= 10;
    public abstract int add(int num1, int num2); //구현체 없이 함수의 정의만 있는 상태->추상 메소드
    //추상메소드인지 구분해주지 않으면 컴파일러는 일반 함수인지 추상 함수인지 모름
}
