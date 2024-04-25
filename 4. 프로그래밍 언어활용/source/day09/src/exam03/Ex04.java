package exam03;

public class Ex04 {
    public static void main(String[] args) {
        String fruits = "Apple, Orange, Mango, Melon, Apple"; //좌->우로 탐색
        System.out.printf("indexOf Apple: %d%n", fruits.indexOf("Apple"));

        System.out.printf("lastIndexOf Apple: %d%n", fruits.lastIndexOf("Apple")); //우->좌로 탐색, 뒤에 있는 애플을 찾는데 왼쪽에서부터 인덱스 번호 매김

        System.out.printf("indexOf Banana: %d%n", fruits.indexOf("Banana")); //없는 경우 -1 출력
    }
}
