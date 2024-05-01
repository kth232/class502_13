package exam01;

import java.util.Arrays;

public class Ex04 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 4};
        boolean isSame = Arrays.equals(nums1, nums2);
        System.out.println(isSame);
        /*
        boolean isSame = true;
            for (int i = 0; i<nums.length;i++) {
                if (nums1[i] != nums2[i]){
                isSame=false;
                break;
            }
        }
         */

        int[][] nums3 = {{1, 2, 3}, {4, 5, 6}};
        int[][] nums4 = {{1, 2, 3}, {4, 5, 6}};
        boolean isSame2= Arrays.equals(nums3, nums4); //1차원 배열만 비교
        System.out.println(isSame2); //false, ->각 배열의 주소 비교
        boolean isSame3 = Arrays.deepEquals(nums3, nums4); //다차원 배열 비교
        System.out.println(isSame3);

    }
}
