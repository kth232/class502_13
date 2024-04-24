package exam04;

import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        //System.out.println(Math.random()*10); //곱하는 수보다 작은 수(0~9)가 정수부분에 랜덤으로 반복출력됨
        //로또 숫자 뽑기 1~43 사이 랜덤 6개 숫자, 중복 x
        //int num = (int)(Math.random()*43); //0~42 사이 정수
        //int num =(int)Math.ceil(Math.random()*43); //올림, 1~43 사이 정수
        int cnt =0;
        int[] lotto = new int[6];

        while(cnt < 6) { //cnt=5일 때 중지
            int num = getNumber();
            if (chkDuplicated(lotto, num)){
                continue; //중복 있으면 건너뛰기
            }
            lotto[cnt] = num;
            cnt++;
        }
        System.out.println(Arrays.toString(lotto));
    }

    public static int getNumber() { //랜덤하게 숫자
        return (int)(Math.random()*43)+1; //1~43
    }
    public static boolean chkDuplicated(int[] lotto, int num) { //중복 체크 로직
        for(int n : lotto){
            if(n == num ) return true;
        }
        return false;
    }
}
