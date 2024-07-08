package exam01;

import exam02.CalculatorHandler;
import exam02.Calculator;
import exam03.RecCalculator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class Ex02 {
    @Test
    void test01() {
        Object obj = Proxy.newProxyInstance(
            Calculator.class.getClassLoader(),
                new Class[] {Calculator.class},
                new CalculatorHandler(new RecCalculator()) // 여기로 유입됨
        );

        Calculator cal = (Calculator) obj;
        long result= cal.factorial(6L);
        System.out.println(result);

        System.out.println(cal);
    }
}
