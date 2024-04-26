package exam04;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<Apple>(); //자료형 명시 <Apple>
        appleBox.setItem(new Apple());
        //appleBox.setItem(new Grape()); //다른 형태로 가져올 시 오류->타입 안정성 확보

        Apple apple = appleBox.getItem(); //형변환할 필요없이 바로 사용 가능
        System.out.println(apple.get());
    }
}
