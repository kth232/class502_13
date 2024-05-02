package exam01;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public class Ex06 {
    public static void main(String[] args) {
        ToIntFunction<String> func1 = s->s.length();//매개변수는 string, 반환값은 int
        ToIntFunction<String> func2 = String::length; //메서드 참조-클래스명::메서드명

        BiPredicate<String, String> cond1 = (s1, s2)->s1.equals(s2); // s1, s2 비교
        BiPredicate<String, String> cond2 = String::equals; // 메서드 참조-참조변수::메서드명
    } //충분히 예상 가능하고 투입되는 순서가 바뀌지 않을 때 메서드 참조로 짧게 쓸 수 있음
} //순서가 바뀌면 다른 값으로 인식하고 직접 정의해줘야 함
