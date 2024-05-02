package exam01;

import java.util.function.BinaryOperator;

public class Ex02 {
    public static void main(String[] args) {
        BinaryOperator<Integer> calc = (a, b)->a + b; //반환값 타입이 동일해서 Integer 타입 한번만 명시
        int result = calc.apply(10, 20);
        System.out.println(result);
    }
}
