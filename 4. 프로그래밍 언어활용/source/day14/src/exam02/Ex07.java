package exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex07 {
    public static void main(String[] args) {
        int[] nums = {22, 11, 10, 2, 6, 8, 33};
        Arrays.stream(nums).map(x -> x * x) //스트림 객체 생성, 내부에서 반복, 중간연산(스트림 계열은 전부 중간연산)
                .filter(x -> x % 2 == 1) //filter: 중간연산
                .forEach(System.out::println);  //최종연산(스트림 계열이 아니면 최종연산)
        /*
        IntStream stm1 = Arrays.stream(nums);
        stm1.map(x->x * x).filter(x -> x % 2 == 1).forEach(System.out::println);
         */
    }
}
