package exam03;

public class Ex02 {
    public static void main(String[] args) {
        Integer num1 = new Integer(10); //사용 지양, 제거 예정
        Integer num2 = new Integer(10); //10이라는 값을 가진 각각 다른 객체 생성->메모리 낭비
        System.out.printf("num1 adress: %d%n", System.identityHashCode(num1));
        System.out.printf("num2 adress: %d%n", System.identityHashCode(num2));
    }
}
