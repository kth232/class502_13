package exam04;

import java.util.Vector;

public class Ex03 {
    public static void main(String[] args) {
        Vector<String> names = new Vector<>(3); //초기 배열 크기값 지정
        System.out.println(names.capacity()); //지정 없을 시 기본 10개 배열 생성
        names.add("name1");
        names.add("name2");
        names.add("name3");
        System.out.println(names.capacity());
        names.add("name4"); //배열 크기 초과
        System.out.println(names.capacity()); //기존의 2배 크기로 새로 배열 생성
    }
}
