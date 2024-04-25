package exam03;

public class Ex03 {
    public static void main(String[] args) {
        String str = "   ";
        System.out.printf("str.isEmpty(): %s%n", str.isEmpty()); //여백 미포함 체크->문자열 없으면 false
        System.out.printf("str.isBlank(): %s%n", str.isBlank()); //여백 포함 문자열 체크
    }
}
