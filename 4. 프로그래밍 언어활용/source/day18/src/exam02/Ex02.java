package exam02;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Ex02 {
    public static void main(String[] args) throws ParseException { //형식이 잘못된 경우 오류 전가
        String price = "1,000,000원";
        DecimalFormat df = new DecimalFormat("#,###원"); //형식 명시
        Number number = df.parse(price); //자료형을 필요에 따라 결정해서 사용
        long num = number.longValue();
        System.out.println(num); //문자열->숫자로 변환
    }
}
