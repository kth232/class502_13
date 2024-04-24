package exam02;

public class Ex02 {
    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "ABC"; //서로 같은 객체->힙 영역-문자열 상수풀에 하나만 저장됨(자원 절약)
        System.out.printf("s1==s2: %s%n", s1 == s2); //true
        System.out.printf("s1 adress: %d%n", System.identityHashCode(s1)); //주소 같음
        System.out.printf("s2 adress: %d%n", System.identityHashCode(s2));
    }
}
