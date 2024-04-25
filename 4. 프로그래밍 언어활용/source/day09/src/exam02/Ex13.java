package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex13 {
    public static void main(String[] args){
        String str = "lee: 010-0000-0000\nkim: 010-0000-1111";
        Pattern p1 = Pattern.compile("([^:]+):\\s*(01[016]\\D*\\d{3,4}\\D*\\d{4})", Pattern.MULTILINE); //이름 그룹: 번호 그룹
        Matcher m1 = p1.matcher(str);
        while(m1.find()){
            System.out.printf("name: %s, phoneNo: %s%n", m1.group(1).replace("\n", ""), m1.group(2));
        }
    }
}
