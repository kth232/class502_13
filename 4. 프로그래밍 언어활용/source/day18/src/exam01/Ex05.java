package exam01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex05 {
    public static void main(String[] args) {
        String strDate = "05/09/24 15:16";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm"); //형식대로 분리
        LocalDateTime date = LocalDateTime.parse(strDate, formatter); //형식화된 데이터를 객체로
        System.out.println(date);
    }
}
