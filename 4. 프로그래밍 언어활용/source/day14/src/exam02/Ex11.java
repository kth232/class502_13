package exam02;

import java.util.Arrays;
import java.util.Comparator;

public class Ex11 {
    public static void main(String[] args) {
        int[] nums = {33, 1, 5, 10, 3, 88, 100, 12};
        int[] nums2 = Arrays.stream(nums).sorted().toArray(); //IntStream 오름차순 정렬 후 새로운 배열 생성/sorted-중간연산, toArray-최종연산
        System.out.println(Arrays.toString(nums2)); //int스트림은 sorted만 있어 오름차순 정렬만 가능

        //내림차순 정렬을 하려면?-> 일반 스트림으로 바꿔서 사용
        int[] nums3 = Arrays.stream(nums).boxed() //Stream<Integer>로 변환(일반 스트림)
                .sorted(Comparator.reverseOrder()) //일반 스트림의 Comparator 사용->역순 정렬
                .mapToInt(x->x).toArray();
        System.out.println(Arrays.toString(nums3));
    }
}
