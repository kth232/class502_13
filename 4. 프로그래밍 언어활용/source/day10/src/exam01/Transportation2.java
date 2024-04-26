package exam01;

public abstract class Transportation2 { //extends java.lang.enum
    public static final Transportation2 BUS = new Transportation2() {}; //미구현된 메서드지만 형식은 맞춰야 함
    public static final Transportation2 SUBWAY = new Transportation2() {};
    public static final Transportation2 TAXI = new Transportation2() {};

    private Transportation2() {} //생성자 private로 통재
} //inner 클래스
/**
 * 1. extends java.lang.enum <-컴파일러가 자동으로 추가-다형성으로 enum 클래스 객체 사용 가능
 * 2. 정적 상수 객체로 생성자 정의 가능
 * 3. 외부 클래스에서 여러 객체를 만들면 상수 객체로써의 가치가 없어짐->생성자 통제, 통제하면 통제수단도 제공해줘야함
 * 4. 추상 클래스
 */