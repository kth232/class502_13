package exam02;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Todos.class) //설정 필수, 어디서 반복해서 담을지 설정
public @interface Todo {
    String value();
}
