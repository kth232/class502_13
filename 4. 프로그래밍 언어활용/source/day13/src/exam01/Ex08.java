package exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex08 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "name1", "name2", "name3"); //배열 형태로 모든 요소 출력
        System.out.println(names);
    }
}
