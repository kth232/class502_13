package exam02;

public class SportCar extends Car{ //final->상속 불가
    public void start() {
        System.out.println("시동 걸기");
    }
    public void press() {
        System.out.println("엑셀 밝기");
    }
    public void turnoff() {
        System.out.println("시동 끄기");
    }
    // public void run() {} // 메서드 재정의 불가
}
