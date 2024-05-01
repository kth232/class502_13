package exam02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Ex01 {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("name1", "name2", "name3", "name4", "name5");
        /*
        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            } //forEach: 반복하는 메서드->Consumer interface의 accept를 호출
        });
         */
        names.forEach(s-> System.out.println(s));
        //일회성 사용, 용도 제한적, 식의 형태로 짧게 표현->람다식
    }
}
