package exam02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex02 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("name3", "name2", "name1"); //문자열 리스트
        Collections.sort(names);
        System.out.println(names);
    }
}
