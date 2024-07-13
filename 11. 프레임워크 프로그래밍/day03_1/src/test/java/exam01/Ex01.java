package exam01;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class Ex01 {
    @Test
    void test01() {
        Object obj = Proxy.newProxyInstance(
                Calculator.class.getClassLoader(), new Class[] {Calculator.class}, new CalculatorHandler(new RecCalculator())
        ); //InvocationHandler에 있는 invoke() 호출

        Calculator cal = (Calculator) obj;
        long result = cal.factorial(6L);
        System.out.println(result);

        System.out.println(cal);
        System.out.println(cal.getClass().getName());
    }
}
