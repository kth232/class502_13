package exam01;

public class Q2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 40; i++) {
            int roomNo = i % 10; //나머지 연산자로 0~9 반복
            System.out.printf("학생: %d, 방번호: %번 %n", i, roomNo);
        }

    }
}
