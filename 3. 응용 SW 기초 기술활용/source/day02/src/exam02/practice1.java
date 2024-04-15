package exam02;

import java.util.Arrays;

public class practice1 {
    public static void main(String[] args) {
        // 배열 요소 거꾸로 출력
        int[] nums = {19, 21, 30, 88};
        int[] reverse=new int[4];
        for (int i=nums.length-1, j=0;i>=0;i--, j++) {
           reverse[j]=nums[i];
        }
        System.out.println("nums: "+ Arrays.toString(nums));
        System.out.println("reverse: "+Arrays.toString(reverse));

        /*
        int[] nums = {19, 21, 30, 88};
        for (int i=nums.length-1;i>=0;i--) {
        System.out.println(nums[i]);
        }
         */


    }
}
