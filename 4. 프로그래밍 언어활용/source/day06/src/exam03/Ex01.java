package exam03;

public class Ex01 {
    public static void main(String[] args) {
        Calculator cal = new SimpleCalculator(); //다형성 가능
        int result1 = cal.add(10, 20);
        System.out.println(result1);

        int result2 = cal.minus(20, 10);
        System.out.println(result2);
    }
}
