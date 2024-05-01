package exam01;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ex10 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("name1", "name2", "name3", "name4", "name5");
        Collections.shuffle(names); //요소 무작위로 섞어줌
        System.out.println(names);
        String max = Collections.max(names); //정렬 후 가장 마지막 요소 출력
        String min = Collections.min(names); //정렬 후 가장 처음 요소 출력
        System.out.printf("max=%s, min=%s%n", max, min);
    }
}
