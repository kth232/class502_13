package exam02;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        /**
         * 수행 작업
         * 1. 문자열 앞 뒤로 *표로 감싸기(*..*)
         * 2. 대문자 변환
         * 3. 출력
         */
        String[] fruits = {"apple", "orange", "mango", "melon"};
        Arrays.stream(fruits).map(s->"*"+s+"*") //배열을 스트림 객체로 변환, 중간연산
                .map(String::toUpperCase) //map(): 변환작업, 중간연산
                .forEach(System.out::println); //forEach() 반복 작업, 메서드 체이닝, 최종연산
    }
}
