package exam02;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class Ex02 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        /* 상수형태로 쓰는 것이 정석이지만 get 함수를 쓰는 것이 더 편하다
        int year = today.get(ChronoField.YEAR);
        int month = today.get(ChronoField.MONTH_OF_YEAR); //1~12
        int day = today.get(ChronoField.DAY_OF_MONTH);
        int week = today.get(ChronoField.DAY_OF_WEEK); //요일 1(월)~7(일)
         */
        int year = today.getYear();
        int month = today.getMonthValue(); //int형태
        int day = today.getDayOfMonth();
        int week = today.getDayOfWeek().getValue(); //int형태

        System.out.printf("year=%d, month=%d, day=%d, week=%d%n", year, month, day, week);
    }
}
