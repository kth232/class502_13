package exam02;

import java.util.Arrays;
import java.util.List;

public class Ex04 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "orange", "mango", "melon");
        fruits.stream().map(s->"*"+s+"*") //컬렉션 객체를 스트림 객체로 변환
                .map(String::toUpperCase) // 메서드 참조: s->s.toUpperCase()
                .forEach(System.out::println); // 메서드 참조: s -> System.out.println(s)

        System.out.println(fruits); //원본 데이터는 유지, 내부적으로 데이터를 복사해서 변형
    }//데이터 출처가 무엇이든 처리 방식 동일함=스트림을 사용하는 목적
}
