package exam01;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex06 {
    public static void main(String[] args) {
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //return o1.compareTo(o2); //오름차순
                return o2.compareTo(o1); //내림차순
                //return o1.compareTo(o2) * -1; //내림차순
            }//정렬 기준 재정의
        };

        //Set<String> names = new TreeSet<>(comp);
        Set<String> names = new TreeSet<>(Comparator.reverseOrder()); //treeSet: 집합 형태+정렬기능 ,다형성 Set으로 형변환

        names.add("name1");
        names.add("name2");
        names.add("name2");
        names.add("name3");
        names.add("name4");
        names.add("name5");
        names.add("name3");
        System.out.println(names); //names.toString()
    } //String은 기본 오름차순으로 comapareTo 정의되어 있음
} // String 메서드는 재정의 불가(final class)
