package exam03;

public class Ex07 {
    public static void main(String[] args) {
        double result = add(10.0, 10L);
        System.out.println(result);
    }

    public static double add(Number num1, Number num2) { //매개변수로 들어오는 값이 정수일지 실수일지 모름
        return num1.doubleValue() + num2.doubleValue(); //정수, 실수 상관없이 변환
    }
}
