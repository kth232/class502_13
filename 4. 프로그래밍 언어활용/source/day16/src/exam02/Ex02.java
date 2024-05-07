package exam02;

import java.util.Calendar;

public class Ex02 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance(); //지역화 설정에 따라 객체 생성
        //System.out.println(cal);
        printDate(cal);
        cal.set(Calendar.MONTH, 0); // 1월->원래 객체를 변경함: 불변성 유지x
        printDate(cal);
    }
    public static void printDate(Calendar cal) {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH); //0~11
        int day = cal.get(Calendar.DAY_OF_MONTH);
        System.out.printf("year=%d, month=%d, day=%d\n", year, month+1, day);
    }
}
