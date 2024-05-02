package exam01;

import java.util.function.IntBinaryOperator;

public class Ex03 {
    public static void main(String[] args) {
        IntBinaryOperator calc = (a, b)->a+b;
        int result = calc.applyAsInt(10, 20);
        System.out.println(result);
    } //기본 자료형으로 값 받아오고 반환하는 기본형 타입 함수형 인터페이스 사용
}
