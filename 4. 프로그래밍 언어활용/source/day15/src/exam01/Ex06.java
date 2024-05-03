package exam01;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex06 {
    public static void main(String[] args) {
        IntStream stm1 = IntStream.rangeClosed(1, 50); //1~50까지 있는 스트림 객체
        IntStream stm2 = IntStream.rangeClosed(51, 100); //51~100까지 있는 스트림 객체
        IntStream stm = IntStream.concat(stm1, stm2); //1~100, 스트림 연결
        int[] nums=stm.toArray();
        System.out.println(Arrays.toString(nums));
    }
}
