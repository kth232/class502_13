package exam03;

public class Ex01 {
    public static void main(String[] args) {
        Integer num1 = new Integer(10);
        double num2 = num1.doubleValue(); //객체가 되어야 사용 가능하다.

        String str = "1000"; //문자열 숫자
        int num3 = Integer.parseInt(str); //int형 숫자로 변환하는 편의기능
    }
}
