package exam01;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ex09 {
    public static void main(String[] args) {
        List<String> chars = Arrays.asList("AA", "BB","AA", "CC", "AA");
        int cnt = Collections.frequency(chars, "AA"); //빈도수 구하기
        System.out.println(cnt);
    }
}
