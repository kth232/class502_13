package exam04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex06 {
    public static void main(String[] args) {
        int[][] nums1 = {{10, 20, 30}, {40, 50, 60}};
        int[][] nums2 = {{10, 20, 30}, {40, 50, 60}}; //다차원 배열일 때
        boolean isSame = Arrays.deepEquals(nums1, nums2);
        System.out.println(isSame);
    }
}
