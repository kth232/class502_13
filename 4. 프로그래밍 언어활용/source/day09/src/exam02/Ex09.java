package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex09 {
    public static void main(String[] args) {
        String mobile="010-3481-2101"; // 강사님 폰번호,,
        System.out.println(checkMobile(mobile));
    }
    public static boolean checkMobile(String mobile) {
        /** 유효한 전화번호인지 체크
         * 010-0000-0000
         * 011-000-0000
         * 016-000-0000
         */

        Pattern pattern = Pattern.compile("^01[016]\\D*\\d{3,4}\\D*\\d{4}$"); //숫자 범위 설정, 01로 시작해서 4자리로 끝나는 패턴, 번호 구분하는 특수기호(숫자 제외)
        Matcher matcher = pattern.matcher(mobile);

        boolean matched = matcher.find(); //번호 체크
        return matched;
    }
}
