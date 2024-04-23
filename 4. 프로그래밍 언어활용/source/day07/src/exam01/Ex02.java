package exam01;

public class Ex02 {
    public static void main(String[] args) {
        //int num3=30;
        Calculator cal = new Calculator() {
            @Override
            public int add(int num1, int num2) { //지역변수이기 때문에 메인함수 내부에 입력해도 상관없다.
                //num3 = 50; //지역변수의 상수화(final)로 값 변경 불가
                return num1+num2;
            }
        };// 메서드 재정의
        Calculator cal2 = (x, y)->x + y; //람다식(반환값, 매개변수)->사용자 정의 함수
    }
}
