package exam03;

public class Board {
    private static Board instance = new Board(); // Board 인스턴스 객체 생성

    private Board() {} // Board 함수 생성(기본 생성자)

    public static Board getInstance() {
        synchronized (Board.class) { //singleton pattern
            if (instance == null) {
                instance = new Board();
            }
            return instance; //인스턴스 값 반환
        }
    }
}