package exam09;

public class Outer {
    public void method() {
        class Inner{
            int num1= 10;

            public void method() {
                System.out.println("call from local inner class");
            }
        }
        Inner inner = new Inner(); //내부 클래스 객체 생성->거의 사용 x
        inner.method();
    }
}
