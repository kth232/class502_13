package exam01;

import java.util.Random;

public class Ex01 {
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i<6; i++) {
            int num = rand.nextInt();
            System.out.println(num); //int 값 랜덤 출력

            boolean bool = rand.nextBoolean();
            System.out.println(bool); //boolean 값 랜덤 출력
        }
    }
}
