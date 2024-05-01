package exam01;

import java.util.Arrays;

public class Ex05 {
    public static void main(String[] args) {
        char[] chars = new char[10];
        Arrays.fill(chars, '*');
        System.out.println(Arrays.toString(chars));

        //user01->use*** 문자 배열 교체
        String userId= "user01";
        char[] chars2 = userId.toCharArray(); //비효율적인 방식
        Arrays.fill(chars2, 3, userId.length(), '*'); //index 3번부터 문자열 길이만큼 *표로 채우기
        System.out.println(Arrays.toString(chars2));
        userId = String.valueOf(chars2); //문자배열 스트링 형태로 출력
        System.out.println(userId);
    }
}
