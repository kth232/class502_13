package exam02;

import java.util.stream.IntStream;

public class Ex13 {
    public static void main(String[] args) {
        int total = IntStream.rangeClosed(1, 100).sum();
        System.out.println(total); //합계 구하기

        int total2 = IntStream.rangeClosed(1, 100).filter(x ->x % 2 == 1).sum();
        System.out.println(total2); //홀수만 더하기
    }
}
