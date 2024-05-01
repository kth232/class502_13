package exam01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex12 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("name3", "name2", "name1", "name5", "name4"); //변경 불가 리스트
        Collections.sort(names); //기본 정렬 기준(Natural Order-java.lang.Comparable, int comparaTo(..))
        System.out.println(names);

        Collections.sort(names, Comparator.reverseOrder()); //역순 정렬 출력
        System.out.println(names);
    }
}
