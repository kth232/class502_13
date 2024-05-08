package exam02;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Ex04 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        String weekStr = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);
        System.out.println(weekStr);

        String weekStr2 = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN);
        System.out.println(weekStr2);

        String weekStrEng = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        System.out.println(weekStrEng);

        String weekStrEng2 = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        System.out.println(weekStrEng2);
    }
}
