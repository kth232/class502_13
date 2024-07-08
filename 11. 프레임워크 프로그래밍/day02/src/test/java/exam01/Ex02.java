package exam01;

import board.services.BoardService2;
import config.AppCtx;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex02 {
    @Test
    void test01() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        //afterPropertiesSet() 호출은 컨테이너 내부에서 발생
        //객체 생성, 의존 설정, 초기화 단계까지 컨테이너 내부에서 진행됨
        
//        BoardService service = ctx.getBean(BoardService.class);
//        service.write();

        BoardService2 s1 = ctx.getBean(BoardService2.class);
        BoardService2 s2 = ctx.getBean(BoardService2.class);
        System.out.println(s1 == s2); // false

        ctx.close(); //close가 호출되어야만 close() 전에 destroy() 호출됨
    }
}
