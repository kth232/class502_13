package exam02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CalculatorHandler implements InvocationHandler {

    private Object obj;

    public CalculatorHandler(Object obj) {
        this.obj = obj;
    }

    /**
     * @param method : 호출한 메서드의 정보
     *                 동적 메서드 호출 method.invoke(...)
     *
     * @param args : 메서드 호출 시 넘겨준 값(인수)
     *
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println(method);
//        System.out.println(Arrays.toString(args));

        System.out.println(proxy.getClass()); //가짜 proxy 객체가 나옴
        long stime = System.nanoTime(); //공통기능
        try {
            //핵심 기능 proxy가 대신 수행
            Object result = method.invoke(obj, args); //invoke가 factorial() 수행

            return result;
        } finally {
            long etime = System.nanoTime(); //공통 기능
            System.out.printf("소요 시간: %d%n", etime - stime);
        }
    }
}