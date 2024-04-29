package exam2;

public class Q2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 40; i++) {
            int roomNo = i % 10;
            System.out.printf("학생: %d번, 방번호: %d %n", i, roomNo);
        }
    }
}
