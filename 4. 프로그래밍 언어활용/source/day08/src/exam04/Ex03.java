package exam04;

import java.util.HashSet;

public class Ex03 {
    public static void main(String[] args) {
        //Set: 중복x
        HashSet<Integer> lotto = new HashSet<>(); //구현된 집합 자료 사용
        while(lotto.size() < 6) {
            lotto.add(getNumber());
        }
        System.out.println(lotto);
    }
    public static int getNumber() {
        return (int)(Math.random()*43)+1; //1~43
    }
}
