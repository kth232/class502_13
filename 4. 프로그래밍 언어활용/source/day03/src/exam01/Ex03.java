package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Schedule s1 = new Schedule(2024, 3, 20);
        System.out.println(s1); //클래스명과 주소 출력, 짧게 쓰기 위해 16진수로 표현
        //System.out.println(s1.toString()); -> 문자열로 출력하는 메소드를 컴파일러가 자동으로 추가, 멤버 변수을 값을 확인하는 용도로 재정의해서 사용함
        //System.out.println(System.identityHashCode(s1)); //주소 10진수로 표현
    }
}
