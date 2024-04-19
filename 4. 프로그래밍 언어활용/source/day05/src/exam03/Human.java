package exam03;

public class Human extends Animal{
    @Override //어노테이션 Override
    public void move(){
        System.out.println("이족보행");
    }

    public void reading() {
        System.out.println("독서");
    }
}
