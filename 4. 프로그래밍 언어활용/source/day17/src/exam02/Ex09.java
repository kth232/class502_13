package exam02;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ex09 {
    public static void main(String[] args) {
        ZonedDateTime zdt1 = ZonedDateTime.now();
        System.out.println(zdt1);

        //ZoneId.getAvailableZoneIds().forEach(System.out::println); //사용가능한 ZoneId 출력

        ZoneId london = ZoneId.of("Europe/London");
        ZonedDateTime londonZdt = zdt1.withZoneSameInstant(london); //런던 시간대
        System.out.println(londonZdt);

        ZonedDateTime newyorkZdt = zdt1.withZoneSameInstant(ZoneId.of("America/New_York")); //뉴욕 시간대
        System.out.println(newyorkZdt);
    }
}
