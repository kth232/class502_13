package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex02 {
    public static void main(String[] args) {
        String str = "I like java and javascript";

        Pattern p1 =Pattern.compile(".*java.*"); //포함관계: 앞뒤로 다른 문자열이 있음
        Matcher m1 = p1.matcher(str);
        boolean match = m1.matches();
        System.out.println(match); //패턴이 처음부터 나오지 않고 java만 있는 것이 아님 false->정확하게 일치하지 않음
    }
}
