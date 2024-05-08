package exam02;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ex08 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDateTime today2 = today.atTime(LocalTime.now()); //날짜+시간
        System.out.println(today2);
    }
}
