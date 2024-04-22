package exam07;

public class Outer {
    int num1=10; //인스턴스 자원, 접근 가능
    static int num3 = 40;

    public void method() {
    }

    class Inner { //인스턴스 내부 클래스
        int num1= 15; //외부와 동일한 변수명으로 정의 시 내부 클래스 변수 먼저 접근함
        int num2 = 20; //인스턴스 자원
        static int num3 = 30; //외부 클래스가 있어야 하기 때문에 static은 사용 못함->16ver부터는 오류 없음..
        public void method() {
            System.out.println("call from instance inner class");
            System.out.printf("num1+num2=%d%n", Outer.this.num1+num2);
        } //this: 외부클래스 객체 자원 사용하는 정적 변수
    }
}
