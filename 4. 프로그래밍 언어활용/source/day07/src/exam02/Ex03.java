package exam02;

public class Ex03 {
    public static void main(String[] args) {
        try {
            int num1 = 10;
            int num2 = 2;
            int result = num1 / num2; // ArithmeticException: 0으로 나눌 때 오류 발생->서비스 중단

            String str = null; // NullPointerException: null일 때 오류 발생
            System.out.println(str.toUpperCase()); //소문자를 대문자로 바꿔줌

            System.out.println(result);
        } catch (ArithmeticException | NullPointerException e) { //ArithmeticException일 때, NPE일 때 해당 코드 처리
            e.printStackTrace(); //오류 발생 위치부터 파생된 위치까지 알려줌
        } // 처리로직이 같다면 줄여서 써도 됨
        System.out.println("very important code..");
    }
}
