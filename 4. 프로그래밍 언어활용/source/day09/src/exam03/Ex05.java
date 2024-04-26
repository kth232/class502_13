package exam03;

public class Ex05 {
    public static void main(String[] args) {
        String str = "I like java and javascript";
        boolean matched = str.matches(".*java.*"); //앞, 뒤에 다른 문자열 유무 상관없이 해당 문자열이 있는지 탐색
        System.out.println(matched);

        String str2 = "      ABC      ";
        String str3 = str2.stripLeading(); // 왼쪽 여백 제거
        String str4 = str2.stripTrailing(); // 오른쪽 여백 제거
        System.out.println(str3);
        System.out.println(str4);
    }
}
