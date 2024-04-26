package exam02;

import java.lang.annotation.ElementType;
import static java.lang.annotation.ElementType.*; //
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={TYPE, METHOD, FIELD}) //짧게 쓰는 것도 가능/ 단, import에 정적 변수로 가져와야 함
//@Target(value={ElementType.TYPE, ElementType.METHOD, ElementType.FIELD}) //mata annotation, 다중설정{}: 적용범위 늘림
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno { //interface class
    int min() default 10; //min 설정 항목 정의-> 클래스 구성요소 중 하나->클래스 클래스 객체가 만들어지고 거기서 정보 확인 가능->애너테이션의 구현체도 같이 확인 가능
    int max() default 50; //max 설정 항목 정의-> 추상 메서드, 기본값 설정 가능/ 추가정보로서 상속받는 클래스에도 전달 필요함
    String[] names() default {"name1"}; //배열 추상메서드, 기본값 설정 가능
    String value();
} //정보를 전달하는데 가장 중요한 것은? 정보를 확인하는 것
