package exam10;

public class Ex02 {
    public static void main(String[] args) {
        Calculator cal = new Calculator() { //메서드 재정의, 객체 생성
            @Override
            public int add(int num1, int num2) { //사용자 정의 기능, 수행할 내용은 필요한 것으로
                return num1+num2;
            }
        };
        int result = cal.add(10, 20);
        System.out.println(result);
    }
}
