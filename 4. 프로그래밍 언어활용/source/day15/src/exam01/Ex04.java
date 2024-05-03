package exam01;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex04 {
    public static void main(String[] args) {
        int[] nums=IntStream.iterate(2, x->x+2).limit(10).toArray(); //2부터 2씩 증가하면서 10개 값 배열 형태로 출력
        System.out.println(Arrays.toString(nums));
    }
}
