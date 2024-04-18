package exam02;

import java.util.Arrays;

public class practice1 {
    public static void main(String[] args) {
        // 배열 요소 거꾸로 출력
        int[] nums = {21, 22, 30, 11, 99, 31};
        for (int i=nums.length-1; i>=0; i--) {
            System.out.println(nums[i]);
        }
        /*
        int[] nums = {21, 22, 30, 11, 99, 31};
        int[] reverse=new int[4];
        for (int i=nums.length-1, j=0;i>=0;i--, j++) {
           reverse[j]=nums[i];
        }
        System.out.println("nums: "+ Arrays.toString(nums));
        System.out.println("reverse: "+Arrays.toString(reverse));
        */
        int[] num = {21, 22, 30, 11, 99, 31};
        //int index = nums.lenght-2-1;
        for (int i =0; i< num.length / 2; i++){ // 반 나누는 식
            int index = num.length - i - 1; //바꿀 위치를 찾는 것

            int temp = num[i]; // 치환하는 식
            num[i] = num[index];
            num[index] = temp;
        }
        System.out.println(Arrays.toString(num));
    }
}
