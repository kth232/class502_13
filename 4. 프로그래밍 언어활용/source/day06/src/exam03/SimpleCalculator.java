package exam03;

public class SimpleCalculator implements Calculator{
    public int add(int num1, int num2){ //재정의 시에도 항상 public이어야 함
        return num1+num2;
        }
    public int minus(int num3, int num4) { //인터페이스의 추상메서드는 사용하지 않더라도 모두 구현해야 함
        return num3-num4;
    }
}
