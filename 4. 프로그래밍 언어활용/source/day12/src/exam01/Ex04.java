package exam01;

import java.util.HashSet;

public class Ex04 {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<>(); //hashSet 중복x, 순서 무시
        names.add("name1");
        names.add("name2");
        names.add("name2");
        names.add("name3");
        names.add("name4");
        names.add("name5");
        names.add("name3");
        System.out.println(names); //names.toString()
    }
}
