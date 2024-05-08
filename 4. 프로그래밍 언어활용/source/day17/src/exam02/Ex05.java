package exam02;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class Ex05 {
    public static void main(String[] args) {
        LocalDate today= LocalDate.now(); //원래 객체에 변형x
        LocalDate lastYear = today.with(ChronoField.YEAR, 2023); //새로운 객체 만들고 반환
        System.out.println("변경x: "+today);
        System.out.println("변경o: "+lastYear);
    }
}
