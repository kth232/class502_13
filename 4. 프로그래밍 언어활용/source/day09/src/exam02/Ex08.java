package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex08 {
    public static void main(String[] args) {
        //4글자로 구성된 단어만 추출
        String str = "AAA\n1234\nBBBB\n45678\nCCCCC\nDDDDDD";
        //Pattern p1 = Pattern.compile("//b....//b"); // . 1개=문자 1개, 양옆 공백 제거
        //Pattern p1 = Pattern.compile("\\b.{4}\\b"); // 4글자
        //Pattern p1 = Pattern.compile("\\b.{4,}\\b"); //4글자 이상
        //Pattern p1 = Pattern.compile("\\b.{4,5}\\b"); //4글자 이상 5글자 이하
        Pattern p1 = Pattern.compile("\\b.{1,4}\\b"); //4글자 이하
        Matcher m1 = p1.matcher(str);
        while (m1.find()) {
            System.out.println(m1.group());
        }
        /*
        if (m1.find()){
            System.out.println(m1.group()); //1234 추출
        }
        if (m1.find()) {
            System.out.println(m1.group()); //BBBB 추출
        }
         */
    }
}
