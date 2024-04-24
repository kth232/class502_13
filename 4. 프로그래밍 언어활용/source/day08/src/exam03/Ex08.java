package exam03;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ex08 {
    public static void main(String[] args) {

    Class cls1 = Person.class; //모든 클래스의 정적 변수, 자동 생성(컴파일러)

    Field[] fields = cls1.getFields(); // 필드 정보
    Method[] methods = cls1.getMethods(); //메서드 정보
    Constructor[] constructors = cls1.getConstructors(); //생성자 정보

    System.out.println("--field--");
    for (Field field : fields) {
        System.out.println(field); //field.toString()
    }

    System.out.println("--constructor--");
    for (Constructor constructor : constructors) {
        System.out.println(constructor); //constructor.toString()
    }

    System.out.println("--method--");
    for (Method method : methods) { //접근 가능한 오브젝트 메서드도 출력
        System.out.println(method); //method.toString()
    }

    Person person = new Person();
    Class cls2 = person.getClass(); //getClass(): 클래스 내부에서 사용할 목적
    }
}
