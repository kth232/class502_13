package exam04;

public interface Seller {
    void sell(); //추상메서드->public abstract 자동 추가

    default void order() { //완전 구현된 인스턴스 메서드
        System.out.println("Seller에서 주문");
    }
    public static void staticMethod() {
        System.out.println("static method, 인터페이스든, 클래스든 사용 가능");
    }
}
