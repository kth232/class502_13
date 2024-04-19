package exam03;

public class Ex03 {
    public static void main(String[] args) {
        Human human = new Human(); //인스턴스 메소드는 가상메소드 테이블에 주소가 서로 매핑되어있음
        human.move(); //human move 함수 주소가 없으면 animal move 함수가 매핑되어 실행

        Animal animal = new Animal(); //메소드는 하나만 존재
        animal.move();
    }
}
