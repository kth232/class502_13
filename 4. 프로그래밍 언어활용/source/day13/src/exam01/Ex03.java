package exam01;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int[][] nums1 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.toString(nums1)); //2차원 배열 각 행의 시작주소 출력
        System.out.println(Arrays.deepToString(nums1)); //배열 값 출력
    }
}
