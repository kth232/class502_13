package exam01;

public class Ex04 {
    public static void main(String[] args) {
        String str1 = new String("ABC");
        String str2 = new String("ABC"); //서로 다른 객체

        System.out.printf("str1 == str2: %s%n", str1 == str2); //false ->주소 다름
        System.out.printf("str1.equals(str2): %s%n", str1.equals(str2)); //true, String-equals(..)-> 동등성 비교 재정의
        System.out.printf("str1 adress: %d%n", System.identityHashCode(str1));
        System.out.printf("str2 adress: %d%n", System.identityHashCode(str2));
    }
}
