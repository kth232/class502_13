package exam01;

import java.time.Instant;

public class Ex01 {
    public static void main(String[] args) {
        Instant today = Instant.now(); //현재 시간(UTC 0시 기준)
        System.out.println(today);

        long time1 = today.getEpochSecond(); //초 단위 -Timestamp
        long time2 = today.toEpochMilli() ; //밀리초 단위 -EpochTime, UID-매우 짧은 시간이여서 중복 가능성 낮음
        System.out.printf("time1=%d, time2=%d%n", time1, time2);
    }
}
