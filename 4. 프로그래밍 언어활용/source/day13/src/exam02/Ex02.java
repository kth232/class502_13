package exam02;

public class Ex02 {
    public static void main(String[] args) {
        int z = 10;
        Calculator cal = (x, y) -> {
        //z=20;
        return x + y + z;
    }; //람다식->'최대한' 짧게 작성

        /* 인터페이스 객체 생성
    Calculator cal = new Calculator() {
        @Override
        public int add(int num1, int num2) {
            return 0;
        }
    };
    */
        int result = cal.add(10, 20);
        System.out.println(result);

        int num3=10;
        Calculator cal2 = new Calculator() {
            @Override
            public int add(int num1, int num2) {
                return num1+num2+num3;
            }
        };

    }
}
