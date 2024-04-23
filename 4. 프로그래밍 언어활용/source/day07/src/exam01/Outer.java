package exam01;

public class Outer {
    /*
     Calculator cal2= new Calculator() {
         // Calculator cal 지역변수->스택 메모리 저장
        //new Calculator() 객체 생성->힙 메모리 저장
        @Override
        public int add(int num1, int num2) {
            return num1+num2;
        }
    };
    */

    public Calculator method(int num3) {
        return new Calculator() { //주소값을 내보내는 것이 목적이기 때문에 변수 선언할 필요없이(∵ 메모리 절약) 반환값(주소값) 바로 내보내기
            // Calculator cal 지역변수->스택 메모리 저장
            //new Calculator() 객체 생성->힙 메모리 저장
            public int add(int num1, int num2) {
                return num1+num2+num3;
            }
        };
        /*
        int result = cal.add(10, 20);
        System.out.println(result);

        return cal; //반환값 cal 자료형=Calculator
         */
        //재정의한 함수를 계속 사용하려면 반환값이 나와도 지역변수 유지되야 함, 스택에서 제거되면 안됨
        //->상수화 되어 데이터 영역에 저장, final 지역변수
    }
}
