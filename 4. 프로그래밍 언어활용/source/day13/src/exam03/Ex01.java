package exam03;

import java.util.function.BiFunction;

public class Ex01 {
    public static void main(String[] args) {
        //제네릭은 배열, 참조 자료형만 가능=기본 자료형 불가
        BiFunction<Integer, Integer, Integer> calc=(a, b)-> a + b;  //매개변수 2개, 반환값 1개 함수형 인터페이스
        int result = calc.apply(1, 2); //이미 정의된 메서드로 사용
        System.out.println(result);
        /**
         * 연산은 기본 자료형만 가능=객체는 연산 불가
         * 1. 언박싱: 연산을 위해 기본값으로 변경 Integer->int(intValue)
         * 2. 오토박싱: 다시 객체로 만들어주기 위해 감쌈->반환값 Integer로
         * 3. 다시 언박싱: int result로 변환
         * 위 순서 반복->성능 저하
         * ->연산은 기본 자료형을 사용하는 것이 좋다
         */
    }
}
