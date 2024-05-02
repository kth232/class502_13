package exam01;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class Ex09 {
    public static void main(String[] args) {
        List<String> alpha = Arrays.asList("abc", "def", "ghi");

        //String[] upperAlpha = alpha.stream().map(s->s.toUpperCase()).toArray(i->new String[i]); //map(): 변환작업
        String[] upperAlpha = alpha.stream().map(String::toUpperCase).toArray(String[]::new); //메서드 참조-최대한 짧게 작성하는 게 목적
        System.out.println(Arrays.toString(upperAlpha));
    }
}
