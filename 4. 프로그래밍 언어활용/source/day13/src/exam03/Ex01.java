package exam03;

import java.util.function.BiFunction;

public class Ex01 {
    public static void main(String[] args) {
        //연산은 기본 자료형만 가능->언박싱>오토박싱>언박싱 반복->성능 저하/기본 연산은 기본 자료형을 사용하는 것이 좋다
        BiFunction<Integer, Integer, Integer> calc=(a, b)-> a + b;
        int result = calc.apply(1, 2);
        System.out.println(result);
    }
}
