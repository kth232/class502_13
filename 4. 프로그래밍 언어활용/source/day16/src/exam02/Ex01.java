package exam02;

import java.util.Date;

public class Ex01 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        int year = date.getYear();
        int month = date.getMonth();
        System.out.printf("year=%d, month=%d%n", year, month+1); //month: 0=1월 ~ 11

        long epochTime = date.getTime(); //1970.1.1 자정, 1000분의 1초 단위로 카운팅
        System.out.println(epochTime); //UID(unique ID)를 만들 때 자주 활용->중복되지 않음
    }
}
