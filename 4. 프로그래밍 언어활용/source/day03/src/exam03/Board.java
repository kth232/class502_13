package exam03;

public class Board {
    private static Board instance = new Board(); // Board 인스턴스 객체 생성

    private Board() {} // Board 함수 생성

    public static Board getInstance() {
        return instance; //인스턴스 값 반환
    }
}