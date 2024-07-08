package exam01;

import config.AppCtx;
import member.controllers.RequestJoin;
import member.services.InfoService;
import member.services.JoinService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    @Test
    void test01() {
        //스프링 컨테이너
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        //Annotationconfig / ApplicationContext

        JoinService joinService = ctx.getBean(JoinService.class);
        InfoService infoService = ctx.getBean(InfoService.class);

        RequestJoin form = RequestJoin.builder()
                .email("test01@test.org ")
                .password("12345678")
                .confirmPassword("12345678")
                .userName("kim")
                .build();

        ctx.close();
    }
}
