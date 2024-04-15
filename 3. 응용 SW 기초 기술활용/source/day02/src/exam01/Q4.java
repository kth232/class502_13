package exam01;

public class Q4 {
    public static void main(String[] args) {
        for (int i=2;i<=9;i++) {
            if (i % 2 == 0) {
                continue; //짝수일 때 건너뛰기, 중첩이 많아지는 것보다 끊어주는 것이 좋다
            }
            System.out.println(i + "단-------");
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d x %d = %d %n", i, j, i * j);
            }
        }
    }
}
