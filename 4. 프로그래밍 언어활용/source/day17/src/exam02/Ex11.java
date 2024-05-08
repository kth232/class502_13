package exam02;

import java.time.Instant;

public class Ex11 {
    public static void main(String[] args) {
        Instant today = Instant.now(); // UTC+0 기준
        System.out.println(today);
    }
}
