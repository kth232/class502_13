package exam02;

import java.util.stream.IntStream;

public class Ex12 {
    public static void main(String[] args) {
        /*
        for (int i = 0; i<10; i++) {
            System.out.println("반복"+i);
        }
         */

        //for문 없이 간단하게 반복문 작성 가능
        IntStream.range(0, 10).forEach(i-> System.out.println("반복"+i)); //0 이상 10 미만


    }
}
