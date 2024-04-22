package exam04;

public interface Buyer {
    void buy(); //추상메서드->public abstract 자동 추가

    default void order() { //default 키워드로 인스턴스 메서드 정의 가능->public처럼 동작함
        System.out.println("Buyer에서 주문"); //완전 구현된 인스턴스 메서드

         privateMethod();
    }
    private void privateMethod() {}
}
