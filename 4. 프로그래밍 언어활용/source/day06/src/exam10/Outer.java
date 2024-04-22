package exam10;

public class Outer {
    public Calculator method(int num3) { //Calculator 자료형, 지역변수 num3
        Calculator cal = new Calculator() {
            @Override
            public int add(int num1, int num2) {
                //num3=100; //final int num3 지역변수의 상수화, 사용중이면 제거되지 않게 함
                return num1+num2+num3;
            }
        }; //함수 내부에서 사용하게 되면 용도가 제한적임->한번만 사용할 수 있음
        return cal; //객체를 외부에서 사용하도록 주소를 반환값으로 공유
    } //지역변수 num3이 연산 후 호출이 끝났는데도 스택에서 제거 안됨
}
