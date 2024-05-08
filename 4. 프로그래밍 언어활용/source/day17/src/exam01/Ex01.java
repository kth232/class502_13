package exam01;

import java.util.Calendar;

public class Ex01 { //파일명과 동일한 클래스가 반드시 있어야 함
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        printDate(cal); //GregorianCalendar
        //cal.set(Calendar.MONTH, 11); //12월, 기존 캘린더 객체 변경됨, 불변성 유지x
        cal.add(Calendar.DAY_OF_MONTH, 150); //150일 후
        printDate(cal);
        cal.add(Calendar.DAY_OF_MONTH, -200); //150-200=-50/50일 전
        printDate(cal);
    }

    public static void printDate(Calendar cal){
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH); //0(=1월) ~ 11(=12월)
        int day = cal.get(Calendar.DAY_OF_MONTH);

        System.out.printf("year=%d, month=%d, day=%d\n", year, month+1, day);
        }
}
