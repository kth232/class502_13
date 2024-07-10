package exam01;

import config.AppCtx;
import member.repositories.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class Ex02 {
    //repository는 인터페이스->프록시를 사용해서 구현체 생성
//    @Autowired
//    private MemberRepository repository;

    @Test
    void test01() {
//        List<Member> members = (List<Member>)repository.findAll();
//        members.forEach(System.out::println);
    }

    @Test
    void test02() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        MemberRepository repository = ctx.getBean(MemberRepository.class);

        ctx.close();
    }
}
