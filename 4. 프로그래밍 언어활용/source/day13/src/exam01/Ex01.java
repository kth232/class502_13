package exam01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        //변경 불가 list, 추가, 수정, 삭제 x
        List<String> names = Arrays.asList("name1", "name2", "name3");
        System.out.println(names);

        //변경이 필요한 경우는 list의 구현 클래스 객체 생성 시 생성자 매개변수로 대입
        List<String> names2 = new ArrayList<>(names);
        names2.remove(0); //새로운 리스트로 생성되어 변경 가능해짐
        System.out.println(names2);
    }
}
