package exam04;

import java.util.Objects;

public class Ex04 {
    public static void main(String[] args) {
        String str = null; //선언한 변수에 객체 참조 유무를 모를 때
        str = Objects.requireNonNullElse(str, ""); // 기본값을 넣어서 오류 방지
        str.toUpperCase(); //NPE(NullPointerException) 발생
    }
}
