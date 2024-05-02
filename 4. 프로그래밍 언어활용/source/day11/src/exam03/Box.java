package exam03;

public class Box<T> { //지네릭 클래스, 객체 생성 시 결정
    private T item; //제네릭 클래스의 자료형 T
    public void method1 (T str1, T str2) { //지네릭 클래스의 자료형 T, Box가 객체가 될 때 T 결정
    }
    public <T> void method2(T str1, T str2){ //지네릭 메서드 T, 호출 시 T의 자료형 결정
    }
}
