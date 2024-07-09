package config;

import exam01.Calculator;
import exam01.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //설정 클래스
//@EnableAspectJAutoProxy(proxyTargetClass = true) //서브 클래스 기반 프록시-> 다형성 가능
@EnableAspectJAutoProxy //AOP 자동 설정 애노테이션, 동적 프록시->임시 클래스가 만들어지고 코드가 추가됨(컴파일된 클래스에는 코드 추가 안됨)
public class AppCtx {

    @Bean
    public ProxyCache proxyCache() {
        return new ProxyCache();
    }

    @Bean
    public ProxyCalculator2 proxyCalculator() {
        return new ProxyCalculator2();
    }

    /*
    @Bean
    public RecCalculator calculator() {
        return new RecCalculator();
    }
     */

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }
}
