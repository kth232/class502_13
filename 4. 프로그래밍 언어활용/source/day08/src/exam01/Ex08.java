package exam01;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex08 {
    public static void main(String[] args) {
        int result1= sum(10, 20, 30, 40);
        int result2 = sum(10, 20);
        System.out.println(result1);
        System.out.println(result2);
    }

    public static int sum(int...nums){ //가변적으로 변수 가져옴
        int total = 0;
        for(int num : nums) { //향상된 for문
            total += num;
        }
        return total;
    }
}
