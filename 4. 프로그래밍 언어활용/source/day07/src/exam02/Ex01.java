package exam02;

public class Ex01 {
    public static void main(String[] args) {
        try {
            int num1 = 10;
            int num2 = 2;
            int result = num1 / num2; // ArithmeticException: 0으로 나눌 때 오류 발생->서비스 중단

            String str = null; // NullPointerException: null일 때 오류 발생
            System.out.println(str.toUpperCase()); //소문자를 대문자로 바꿔줌

            System.out.println(result);
        } catch (ArithmeticException e) { //ArithmeticException일 때 해당 코드 처리
            e.printStackTrace(); //오류 발생 위치부터 파생된 위치까지 알려줌
        } catch (Exception e) { //NullPointerException일 때 해당 코드 처리
            System.out.println("유입"); // 어떤 예외인지 모르겠다? 상위 클래스인 exception or runtimeException 다형성 이용해서 유입됨
            e.printStackTrace();
        } //->가장 상위클래스 예외는 가장 마지막에 정의해야 함, 위에서 체크되면 아래는 체크하지 않기 때문
        System.out.println("very important code..");
    }
}
