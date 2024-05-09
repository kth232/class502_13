package Task;

import java.time.LocalDate;
import java.util.Scanner;

public class CalendarTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("연도 월을 입력하세요: ");
            String input = sc.nextLine(); //입력 예) 2024 5

        if(input.equals("exit")) {
            System.out.println("종료합니다.");
            break;
        }//exit를 입력하면 종료

        try {
            String[] data = input.split("\\s+");
            int year = Integer.parseInt(data[0]);
            int month = Integer.parseInt(data[1]);

            System.out.printf("------- %d년 %d월 -------%n", year, month);
            System.out.println("일  월  화  수  목  금  토");

        }catch(Exception e){ // 숫자 형식 오류가 발생한 경우
            System.out.println("입력 형식이 잘못되었습니다. 입력 예) 2024 5");
        }
        }
    }
    public static Object getCalendar(int year, int month){
        /** 로직 핵심포인트
         * 1. 매월 1일이 어떤 요일에 시작하는지
         * 2. 매월 종료일이 무엇인지(30, 31, 28, 29)
         */

        LocalDate startDate = LocalDate.of(year, month, 1); //매월 1일
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);
        int week = startDate.getDayOfWeek().getValue(); //1(월)~7(일)->0(일)~6(토)




        return null;
    }
}
