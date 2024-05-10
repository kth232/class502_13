package Task;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class ref {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate startDate = LocalDate.of(today.getYear(), today.getMonth(), 1);
        int week = startDate.getDayOfWeek().getValue(); //1(월)~7(일)
        System.out.println(week); //1일의 요일

        String weekdp = startDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN); //1(월)~7(일)
        System.out.println(weekdp); //1일의 요일

        //요일을 0(일)~6(토)로 바꾸려면? week % 7 ->일=0

        LocalDate endDate = startDate.plusMonths(1).minusDays(1);
        System.out.println(endDate); //마지막 일자


    }
}
