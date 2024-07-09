package exam01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorHandler implements InvocationHandler {
    
    private Object obj;
    
    public CalculatorHandler(Object obj) {
        this.obj = obj; //생성자 매개변수로 원래 객체 
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //proxy는 가짜 객체->인터페이스 기반이기 때문에 인터페이스를 구현하는 프록시 형태 임시 클래스
        long stime = System.nanoTime(); //추가 기능-공통 기능, 공통 관심사
        try {
            Object result = method.invoke(obj, args); //Calculator factorial 호출, 핵심 기능 대신 수행

            return result;
        } finally {
            long etime = System.nanoTime(); //추가 기능-공통 기능, 공통 관심사
            System.out.printf("소요 시간: %d%n", etime - stime);
        }
    }
}
