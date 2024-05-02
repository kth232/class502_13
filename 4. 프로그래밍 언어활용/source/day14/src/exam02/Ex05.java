package exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex05 {
    public static void main(String[] args) {
        int[] nums={21, 10, 15, 34, 40, 76};

        IntStream stm = Arrays.stream(nums);
        int total = stm.map(x->x * x).sum(); // 각 요소를 제곱한 후 더함, 내부에 for문 들어있음->알아서 반복 수행
        System.out.println(total);

        //오류 발생: 스트림이 이미 사용되어 재사용 불가
        stm=Arrays.stream(nums); //다시 사용하려면 새로 스트림 객체를 생성해야 함
        int total2 = stm.map(x->x * x * x).sum(); // 각 요소를 세제곱한 후 더함
        System.out.println(total2);
    }
}
