package exam01;

import java.util.Calendar;

public class Ex02 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        //cal.add(Calendar.MONTH, 10);
        cal.roll(Calendar.MONTH, 30); // month만 영향 받음
        printDate(cal);
    }
    public static void printDate(Calendar cal){
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH); //0(=1월) ~ 11(=12월)
        int day = cal.get(Calendar.DAY_OF_MONTH);

        System.out.printf("year=%d, month=%d, day=%d\n", year, month+1, day);
    }
}
