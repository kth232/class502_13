package exam02;

import java.time.LocalTime;

public class Ex07 {
    public static void main(String[] args) {
        LocalTime today = LocalTime.now();
        LocalTime time = LocalTime.of(15, 55, 40);

        System.out.println("현재 시간: "+today);
        System.out.println("지정 시간: "+time);
    }
}
