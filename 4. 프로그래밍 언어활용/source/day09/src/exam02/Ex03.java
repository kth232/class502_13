package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex03 {
    public static void main(String[] args) {
        String str = "123 a123 efg 12b3";
        Pattern p1 = Pattern.compile("[abc]"); //문자열 클래스, 클래스 안에 있는 문자 중 하나라도 있으면 true
        Matcher m1= p1.matcher(str);
        if (m1.find()) {
            System.out.println(m1.group());
        }; //패턴a 찾으면 출력 반복
        if (m1.find()) {
            System.out.println(m1.group());
        }; //패턴b 찾으면 출력 반복
    }
}
