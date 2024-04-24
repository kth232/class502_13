package exam02;

public class Ex01 {
    public static void main(String[] args) {
        String s1 = new String("ABC");
        String s2 = new String("ABC"); //서로 다른 객체
        System.out.printf("s1==s2: %s%n", s1==s2); //false
        System.out.printf("s1 adress: %d%n", System.identityHashCode(s1)); //주소 다름
        System.out.printf("s2 adress: %d%n", System.identityHashCode(s2));
    }
}
