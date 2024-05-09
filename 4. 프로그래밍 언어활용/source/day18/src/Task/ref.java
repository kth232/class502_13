package Task;

import java.time.LocalDate;

public class ref {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate startDate = LocalDate.of(today.getYear(), today.getMonth(), 1);
        int week = startDate.getDayOfWeek().getValue(); //1(월)~7(일)
        //요일을 0(일)~6(토)로 바꾸려면? week % 7
        System.out.println(week); //1일의 요일

        LocalDate endDate = startDate.plusMonths(1).minusDays(1);
        System.out.println(endDate); //마지막 일자
    }
}
