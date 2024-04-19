package exam03;

public class Tiger extends Animal{
    public void move(){
        System.out.println("사족보행");
    }
    /*
    @Override
    public void move() {
        super.move(); //상위 클래스 animal 객체의 메서드를 재사용
    }
    */

    public void hunting() {
        System.out.println("사냥");
    }
}
