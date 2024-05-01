package exam01;

import java.util.Arrays;

public class Ex06 {
    public static void main(String[] args) {
        String[] fruits1 = {"apple", "orange", "mango", "melon"};
        String[] fruits2 = {"apple", "orange", "grape", "lemon"};

        int pos = Arrays.mismatch(fruits1, fruits2); //동일한 경우 -1
        System.out.println(pos); //index 2에서 차이점 발생, 차이점 발생 위치 반환
    }
}
