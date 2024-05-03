package exam01;

import java.util.Random;

public class Ex03 {
    public static void main(String[] args) {
        Random rand = new Random();

        rand.ints().limit(6).forEach(System.out::println); //난수 6개 제한, 정수 범위로 출력
    }
}
