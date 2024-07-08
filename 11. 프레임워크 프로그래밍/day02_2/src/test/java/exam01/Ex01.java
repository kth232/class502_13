package exam01;

import org.junit.jupiter.api.Test;

public class Ex01 {
    @Test
    void test01() {
        long stime = System.nanoTime(); //공통 기능
        ImplCalculator cal1 = new ImplCalculator();
        long result1 = cal1.factorial(6L); //핵심기능
        System.out.printf("cal1 = %d%n", result1);
        long etime= System.nanoTime(); //공통기능
        System.out.printf("소요시간: %d%n", etime - stime);

        stime = System.nanoTime(); //공통 기능
        RecCalculator cal2 = new RecCalculator();
        long result2 = cal2.factorial(6L); //핵심기능
        System.out.printf("cal2 = %d%n", result2);
        etime = System.nanoTime();
        System.out.printf("소요시간: %d%n", etime - stime);
    }

    @Test
    void test02() {
        //알게 모르게 도와주도록 하려면? 다형성 이용
        //ProxyCalculator cal1 = new ProxyCalculator(new ImplCalculator()); //프록시가 대신 수행
        Calculator cal1 = new ProxyCalculator(new ImplCalculator());
        long result1 = cal1.factorial(6L);
        System.out.printf("cal1 = %d%n", result1);

        ProxyCalculator cal2 = new ProxyCalculator(new RecCalculator());
        long result2 = cal2.factorial(6L);
        System.out.printf("cal2 = %d%n", result2);
    }
}
