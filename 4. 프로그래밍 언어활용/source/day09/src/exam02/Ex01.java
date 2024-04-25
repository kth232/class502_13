package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex01 {
    public static void main(String[] args) {
        String str = "I like java and javascript";

        Pattern p1 =Pattern.compile("java"); //
        Matcher m1 = p1.matcher(str); //문자 유무 체크, 문자 교체 등의 편의기능
        System.out.println(m1.find()); //true->str의 첫번째 java
        System.out.println(m1.group()); //패턴에 일치하는 문자열 출력

        System.out.println(m1.find()); //true->str의 두번째 java, 호출할 때마다 다음 커서로 이동
        System.out.println(m1.group()); //패턴에 일치하는 문자열 출력

        System.out.println(m1.find()); //false , 많은 코드 중에서 특정 패턴을 찾기 위해 반복문과 자주 사용
        System.out.println(m1.group()); //에러->일치하는 문자열 없음
    }
}
