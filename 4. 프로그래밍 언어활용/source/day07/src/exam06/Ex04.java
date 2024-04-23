package exam06;

public class Ex04 {
    public static void main(String[] args) {
        String str1 = new String("ABC");
        String str2 = new String("ABC"); //새로운 다른 객체 2개 생성
        System.out.printf("str1==str2: %s%n", str1==str2);
        System.out.printf("b1.equals(b2): %s%n", str1.equals(str2)); //equals =동등성 비교, 비교의 기준이 다름
    }
}
