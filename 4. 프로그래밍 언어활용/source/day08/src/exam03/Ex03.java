package exam03;

public class Ex03 {
    public static void main(String[] args) {
        Integer num1 = Integer.valueOf(10); //권장하는 문법
        Integer num2 = Integer.valueOf(10); //동일한 객체 공유

        System.out.printf("num1 adress: %d%n", System.identityHashCode(num1));
        System.out.printf("num2 adress: %d%n", System.identityHashCode(num2));
    }
}
