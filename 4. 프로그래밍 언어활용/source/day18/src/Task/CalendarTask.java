package Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

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
            System.out.println("SUN MON THE WED THU FRI SAT");
            int[] days = getCalendar(year, month);
            for(int i = 0; i<days.length;i++){
                int day = days[i];
                if (day>0){
                    System.out.printf("%2d  ", day); //2자리 정수, 남는 자리수는 공백을 채움
                }else{ //음수일 때 공백으로 채움
                    System.out.print("    ");
                }

                if((i+1)%7==0) {//7칸마다 줄개행
                    System.out.println();
                }
            }
            System.out.println();

        }catch(Exception e){ // 숫자 형식 오류가 발생한 경우
            System.out.println("입력 형식이 잘못되었습니다. 입력 예) 2024 5");
        }
        }
    }
    public static int[] getCalendar(int year, int month){
        /** 로직 핵심포인트
         * 1. 매월 1일이 어떤 요일에 시작하는지
         * 2. 매월 종료일이 무엇인지(30, 31, 28, 29)
         * * 규칙성 파악하기
         */
        LocalDate startDate = LocalDate.of(year, month, 1); //매월 1일
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);
        int week = startDate.getDayOfWeek().getValue() % 7; //기존: 1(월)~7(일)->나머지 연산으로 순서 변경: 0(일)~6(토)
        int start = week * -1 + 1; //매월 1일의 위치 찾는 로직
        int[] days = IntStream.rangeClosed(start, endDate.getDayOfMonth()).toArray();

        return days;
    }
}
