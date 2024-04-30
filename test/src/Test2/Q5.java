package Test2;

import java.util.Arrays;

public class Q5 {
    public static void main(String[] args) {
        int[] nums = {21, 22, 30, 11, 99, 31};
        int[] reverse = new int[6];
        for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
            reverse[j] = nums[i];
        }
        System.out.printf("reverse: %s", Arrays.toString(reverse));
    }
}
