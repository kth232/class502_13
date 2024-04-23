package exam01;

public class Ex03 {
    public static void main(String[] args) {
        A a = new A() {
            public void method() {
                System.out.println("method overriding");
            }
        };//객체 생성과 동시에 메서드 재정의
        a.method();
    }
}
