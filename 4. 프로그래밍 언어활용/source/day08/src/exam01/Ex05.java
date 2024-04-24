package exam01;

import java.util.HashSet;

public class Ex05 {
    public static void main(String[] args) {
        HashSet<String> data = new HashSet<>();
        data.add("AAA");
        data.add("BBB");
        data.add("AAA"); //hashCode 동일
        data.add("CCC");
        System.out.println(data); //중복 없는 데이터 집합
    }
}
