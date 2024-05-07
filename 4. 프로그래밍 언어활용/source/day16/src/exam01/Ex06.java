package exam01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex06 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "orange", "melon", "mango");
        String str = fruits.stream().collect(Collectors.joining(", ")); //,로 묶어서 하나의 문자열로 출력
        System.out.println(str);
        String str2 = fruits.stream().collect(Collectors.joining("#", "**", "^^"));
        System.out.println(str2);
    }
}
