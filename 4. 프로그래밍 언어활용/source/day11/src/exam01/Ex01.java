package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>(); //자료형 결정 시점: 객체를 생성하는 시점
        appleBox.setItem(new Apple());
        // appleBox.setItem(new Grape()); //다른 타입 입력 허용x, 오류를 통한 타입 안정성 확보

        Apple apple = appleBox.getItem(); //형변환x
        System.out.println(appleBox);
    } // 앞에 있는 자료형을 보고 뒤에 있는 자료형도 명확하게 알 수 있으면 굳이 입력하지 않아도 인식 가능
}
