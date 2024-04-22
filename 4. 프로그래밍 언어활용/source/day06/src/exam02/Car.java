package exam02;

public abstract class Car {
    public abstract void start();
    public abstract void press();
    public abstract void turnoff();

    public final void run() { //템플릿 메서드 패턴, 모든 하위클래스에서 순서대로 수행하도록 함
        start();
        press();
        turnoff();
    } //재정의 시 순서 변경 불가하도록 final 예약어
}
