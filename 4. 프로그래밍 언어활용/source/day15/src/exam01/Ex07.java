package exam01;

import java.util.Arrays;
import java.util.List;

public class Ex07 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "orange", "mango", "melon");

        String[] selected = fruits.stream()
                .peek(System.out::println)
                .skip(2) //2개 건너뛰기
                .limit(2)
                //.toArray(i -> new String[i]);
                .toArray(String[]::new);

        System.out.println(Arrays.toString(selected));
    }
}
