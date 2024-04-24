package exam03;

public class Ex05 {
    public static void main(String[] args) {
        int num1 = 100; //기본 자료형
        Integer num2 = Integer.valueOf(200); //객체형 참조 자료형 ->연산 불가

        int result = num1 +num2; //컴파일러가 int형으로 자동으로 바꿔줌 ->num2.intValue()->감싸져있는 Integer 객체 안의 값을 꺼내옴 =언박싱
        System.out.println(result);

        Integer num3 = Integer.valueOf(100);
        Integer num4 = Integer.valueOf(200);
        int result2 = num3.intValue() + num4.intValue(); //Integer 객체의 값을 꺼낸 것
        System.out.println(result2);
    }
}
