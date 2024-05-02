package exam02;

import java.util.Arrays;
import java.util.List;

public class Ex10 {
    public static void main(String[] args) {
        List<Integer> scores = Arrays.asList(60, 78, 90, 87, 96);
        long sum = scores.stream().mapToInt(x->x).sum(); //stream<Integer> 일반스트림(컬렉션)
        //일반스트림을 mapToInt()로 IntStream으로 바꿔주면 합계 기능 사용 가능
        System.out.println(sum);
    }
}
