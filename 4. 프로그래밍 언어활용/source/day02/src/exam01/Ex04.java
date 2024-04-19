package exam01;

public class Ex04 { //exam01.Ex04 ->실제 클래스명
    public static void main(String[] args) {
        int result1 = add(10, 20); //int add(int, int)
        System.out.println(result1);

        int result2 = add(10, 20, 30); //int add(int, int, int)
        System.out.println(result2);

        double result3 = add(10.2, 20.6); //double add(double, double)
        System.out.println(result3);

    }
    static int add(int num1, int num2) {
        return num1+num2;
    }
    static int add(int num1, int num2, int num3) {
        return num1+num2+num3; //함수명은 같지만 매개변수가 달라지면 다른 함수->메서드 오버로드
    }
    static double add(double num1, double num2) {
        return num1 + num2;
    }
}

