package exam01;

import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = Arrays.copyOf(nums1, 3); //0번부터 원하는 길이만큼 배열 복사
        int[] nums3 = Arrays.copyOfRange(nums1, 1, 5); // index 1번부터 5번 미만까지 범위 배열 복사
        System.out.println(nums1);// 배열의 시작주소 출력
        System.out.println(Arrays.toString(nums1)); //배열 요소 출력
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
    }
}
