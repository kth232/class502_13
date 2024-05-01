package exam01;

import java.util.Arrays;
import java.util.Comparator;

public class Ex07 {
    public static void main(String[] args) {
        int[] nums = {22, 1, 5, 10, 96, 54};
        Integer[] nums2 = {22, 1, 5, 10, 96, 54};
        //기본 정렬, Integer 기본 정렬 기준-java.lang.Comparable, int comparTo(..)
        Arrays.sort(nums);
        Arrays.sort(nums2, Comparator.reverseOrder()); //Comparator는 지네릭 타입 사용->Comparator를 사용하려면 wrapper 클래스 형태로 묶어서 사용
        System.out.println(Arrays.toString(nums));
    }
}
