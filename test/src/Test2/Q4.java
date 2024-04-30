package Test2;

public class Q4 {
    public static void main(String[] args) {
        for (int i = 2; i <= 9; i++) {
            System.out.printf("%d단----%n", i);
            for (int j = 1; j <= 9; j++) {
                if (i > j) {
                    continue;
                }
                System.out.printf("%d * %d = %d%n", i, j, i * j);
            }
        }
    }
}
