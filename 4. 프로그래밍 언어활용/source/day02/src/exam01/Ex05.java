package exam01;

import java.lang.reflect.Method;

public class Ex05 {
    public static void main(String[] args) {
        Class cls = Student.class;

        Method[] methods = cls.getMethods(); //정보성 객체, 클래스 정보를 담고 있다.
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
