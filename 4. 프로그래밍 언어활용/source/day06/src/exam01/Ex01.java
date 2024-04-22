package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Calculator cal = new SimpleCalculator(); //다형성 가능, 변경 유연성 o->설계 틀만 같게 유지하면 다른 클래스 교체 가능
        int result = cal.add(10, 20);
        System.out.println(result);

        System.out.println(Calculator.NUM); //정적 상수
    }
}
