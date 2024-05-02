package exam02;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class Ex06 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] nums2 = map(nums,x -> x * x);
        /*
        int[] nums2 = map(nums, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int num) { //사용자 정의 메서드
                return num * num;
            }
        });*/
        System.out.println(Arrays.toString(nums2));
    }
    public static int[] map(int[] nums, IntUnaryOperator oper) {//map-Function interface, 매개변수와 반환값이 int형
        int[] newNums = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            newNums[i] = oper.applyAsInt(nums[i]); //내부에서 추상메서드 호출, 값만 제공
        }
        return newNums;
    }
}
