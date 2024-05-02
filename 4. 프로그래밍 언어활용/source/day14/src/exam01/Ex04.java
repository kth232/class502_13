package exam01;

import java.util.function.Function;

public class Ex04 {
    public static void main(String[] args) {
        Function<String, Integer> func1 = s -> s.length(); //문자열 받으면 문자열 길이 반환
        Function<Integer, Integer> func2 = x -> x * x; //제곱
        Function<String,Integer> func3 = func1.andThen(func2); //함수의 결합: func1 수행 후 반환값으로 func2 수행
        Function<String, Integer> func4 = func2.compose(func1); //반대 방향으로 결합(함수에 맞게 타입 명시해야 함): func1->func2 수행
        //int len = func1.apply("ABC");
        //System.out.println(len);

        int num = func3.apply("ABC"); //ABC->3->9
        System.out.println(num);

        int num2 = func4.apply("ABC"); //ABC->3->9
        System.out.println(num2);
    }
}
