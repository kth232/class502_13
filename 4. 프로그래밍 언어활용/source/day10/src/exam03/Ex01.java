package exam03;

public class Ex01 {
    public static void main(String[] args) {
        Box appleBox = new Box();
        appleBox.setItem(new Apple()); //생성과 동시에 구현해서 담음

        Apple apple = (Apple) appleBox.getItem(); //다형성-명시적 형변환->매번 변환해줘야 하는 번거러움
        System.out.println(apple.get());

        Box grapeBox = new Box();
        grapeBox.setItem(new Grape());

        if (grapeBox.getItem() instanceof Apple) { //매번 내용 확인해봐야 함->타입 안정성 떨어짐
            Apple grape = (Apple) grapeBox.getItem(); //다형성-명시적 형변환, 포도인데 사과로 접근=>오류
            System.out.println(grape.get());
        }
    }
}
