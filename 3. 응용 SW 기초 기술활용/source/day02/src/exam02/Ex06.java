package exam02;

import java.util.Arrays; //자바 배열 유틸 가져오기

public class Ex06 {
    public static void main(String[] args) {
        int[][] nums = {{10, 20, 30} ,{40, 50, 60}}; //2차원 배열
        System.out.println(nums); //배열변수 주소 출력
        System.out.println(Arrays.toString(nums)); //각 행의 배열 주소 출력
        System.out.println(Arrays.deepToString(nums)); // 2차원 배열 요소 출력 유틸
        /*
        System.out.println(nums.length); // 행의 개수
        System.out.println(nums[0].length); //0번째 행의 열의 개수
        System.out.println(nums[1].length); //1번째 행의 열의 개수

        for (int i=0;i<nums.length;i++) {
            for (int j=0;j<nums[i].length;j++) {
                System.out.println(nums[i][j]); //i행 j열 요소 출력
            }
        }
         */
    }
}
