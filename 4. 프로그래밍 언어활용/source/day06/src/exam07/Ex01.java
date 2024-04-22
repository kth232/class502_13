package exam07;

public class Ex01 {
    public static void main(String[] args) {
        Outer outer = new Outer(); // 외부클래스 객체 생성
        Outer.Inner inner = outer.new Inner(); //인스턴스 내부 클래스 객체 생성
        inner.method(); //인스턴스 내부 클래스 메서드 호출
    }
}
