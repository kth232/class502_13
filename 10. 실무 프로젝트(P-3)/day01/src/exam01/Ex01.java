package exam01;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) throws Exception {
        //reflection API
        Class clazz = JoinService.class;

        Constructor[] constructors = clazz.getDeclaredConstructors(); //모든 범위의 생성자 메서드를 조회
        for (Constructor constructor : constructors) {
            System.out.println("매개변수 개수: "+ constructor.getParameterTypes().length);
            
            List<Object> arguments = new ArrayList<>();
            for(Class clz: constructor.getParameterTypes()){
                if (clz == String.class){ //문자열
                    arguments.add("string");
                } else if (clz == int.class){ //기본 자료형 int
                    arguments.add(100);
                } else if (clz == long.class) { //기본 자료형 long
                    arguments.add(200L);
                } //매개변수를 특정할 수 없을 때 동적으로 할당
            }

            Object obj = arguments.isEmpty() ? constructor.newInstance() : constructor.newInstance(arguments.toArray());
            //비어있으면 비어있는 상태로, 있으면 있는 걸로
            JoinService service = (JoinService) obj;
            //System.out.println(service); //JoinService 객체 출력
        }

        /*
        Constructor c1 = constructors[0];
        Constructor c2 = constructors[1];
        Constructor c3 = constructors[1];

        JoinService s1 = (JoinService) c1.newInstance(); //동적 객체 생성
        JoinService s2 = (JoinService) c2.newInstance("값1", 100); // 유연성 떨어짐
        JoinService s3 = (JoinService) c3.newInstance(new Object[] {"값2", 200}); //배열로 사용
        //대상이 특정되지 않았을 때
        */

        /*
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
         */
    }

}
