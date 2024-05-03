package exam01;

import java.util.Optional;
import java.util.OptionalInt;

public class Ex08 {
    public static void main(String[] args) {
        //String str = "ABC";
        String str = null;
        //Optional<String> opt = Optional.of(str); //null 있으면 ->NPE 발생: null은 허용x
        Optional<String> opt = Optional.ofNullable(str); //null 허용
        //System.out.println(opt.get()); //안에 있는 객체의 값을 꺼내옴, null이면 NoSuchElementException 발생
        String value = opt.orElse("default");//값이 있으면 반환, 없으면 기본값 반환
        System.out.println(value);
    }
}
