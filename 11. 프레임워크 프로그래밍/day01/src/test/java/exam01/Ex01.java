package exam01;

import exam01.config.AppCtx;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    @Test
    void test01() {
        // class 클래스, 스프링 컨테이너 객체
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        //생성된 객체 컨테이너 안에서 꺼내옴-> 생성 안해도 사용 가능
        Greeter g1 = ctx.getBean("greeter", Greeter.class); //메서드명이 빈의 이름이 됨
        g1.hello("lee");

        Greeter g2 = ctx.getBean("greeter", Greeter.class); //메서드명이 빈의 이름이 됨
        g2.hello("kim");
        //동일한 자료형의 객체를 여러개 사용할 경우는 지정해야 찾을 수 있다

        System.out.println(g1 == g2); //주소 비교-싱글톤 형태로 관리

        ctx.close();
    }
    
    @Test
    void test02() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        
        Greeter g1 = ctx.getBean(Greeter.class); 
        //싱글톤으로 기본 관리하기 때문에 객체가 1개만 있는 경우가 대부분임->class 클래스만 있어도 찾을 수 있음
        g1.hello("lee");
        
        ctx.close();
    }
}
