package exam08;

public class Outer {
    int num1 = 10;
    static int num2= 20; //정적 변수는 접근 가능

    static class Inner{
        public void method() {
            System.out.println("call from static inner class");
            // System.out.println(num1); //외부 클래스의 객체가 되든 관련x, 외부 클래스 인스턴스 객체 자원 접근 불가->this 없음
            System.out.println(num2);
        }
    }
}
