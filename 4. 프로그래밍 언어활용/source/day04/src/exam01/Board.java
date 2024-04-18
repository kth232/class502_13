package exam01;

public class Board {
    private static Board instance = new Board(); //인스턴스 객체 정적 변수로 생성, 클래스 로드 시점부터 객체 생성

    static {
        System.out.println("static block,처음부터 실행, 객체 생성과 무관");
    }

    private Board() {}; //생성자 외부 호출 막기
    public static Board getInstance() { //참조변수가 없을 때 기본값=null
        if (instance == null) { //필요한 시점 최초 1번만 생성
            instance = new Board();
        }
        return instance; //객체 상관없이 접근 가능한 함수 생성
    }
}
