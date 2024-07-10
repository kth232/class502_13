package exam01;

import config.AppCtx;
import member.controllers.RequestJoin;
import member.services.JoinService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@Transactional //롤백되어 테스트 내용이 DB에 남지 않음
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class Ex04 { //단위 테스트->기능 테스트

    @Autowired //완성된 객체로 의존성 주입 가능
    private JoinService service; 

    @Test
    void test01() {
        RequestJoin form = new RequestJoin();
        form.setEmail("user98@test.org");
        form.setPassword("12345678");
        form.setConfirmPassword(form.getPassword());
        form.setUserName("user98");
        form.setAgree(true);

        service.process(form);
    }
}
