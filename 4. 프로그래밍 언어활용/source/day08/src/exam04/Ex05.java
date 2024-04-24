package exam04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex05 {
    public static void main(String[] args) {
        int[] nums1 = {10, 20, 30, 40};
        int[] nums2 = {10, 20, 30, 40};

        boolean isSame = Arrays.equals(nums1, nums2);
        System.out.println(isSame);

        /*
        boolean isSame = true;
        for(int i=0;i<nums1.length; i++) { //배열 2개 비교
                if(nums1[i] != nums2[i]) {
                    isSame = false; //같지 않은 값이 나타나면 중지
                    break; // break문으로 중단되면 다시 for문으로 돌아감
            }
        }
        System.out.println(isSame);
         */
    }
}
