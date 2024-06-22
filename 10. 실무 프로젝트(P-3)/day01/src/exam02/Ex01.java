package exam02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) throws Exception{
        Class clazz = Member.class; //생성자 1개

        Constructor constructor = clazz.getDeclaredConstructors()[0]; //모든 범위의 생성자 메서드를 조회, 0번째 요소
        Object obj = constructor.newInstance(); //특정할 수 없는 어떤 객체임을 가정하고 생성
        
        Method[] methods = clazz.getDeclaredMethods(); //모든 메서드 확인 가능
        for (Method method : methods) {
            //System.out.println(method);
            String name = method.getName(); //메서드명 가져옴
            if (!name.startsWith("set")) {
                continue;
            }
            
            Class clz = method.getParameterTypes()[0]; // 매개변수 타입 배열 반환
            Object arg = null;
            if (clz == String.class) { //setter 메서드의 매개변수가 문자열
                arg = "String";
            } else if (clz == LocalDateTime.class) { //setter 메서드의 매개변수가 LocalDateTime
                arg = LocalDateTime.now();
            }
            method.invoke(obj, arg); //setter 메서드 호출
            //invoke(): method를 동적으로 실행시켜주는 메서드
        }
        System.out.println(obj);
        //어떤 메서드, 어떤 객체인지 몰라도 정보 확인 가능
    }
}
