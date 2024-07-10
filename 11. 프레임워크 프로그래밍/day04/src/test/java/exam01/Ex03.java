package exam01;

import config.AppCtx;
import mappers.member.MemberMapper;
import member.entities.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class Ex03 {

    @Autowired
    private MemberMapper memberMapper;
    
    @Test
    void test01() {
        //System.out.println(memberMapper); //인터페이스->프록시 클래스로 구현체 만들어짐
        long total = memberMapper.getTotal();
        System.out.println(total);
    }

    @Test
    void test02() {
        Member member = Member.builder()
                .email("user05@test.org")
                .password("123456")
                .userName("user05")
                .build();

        int result = memberMapper.register(member);

        Member member2 = memberMapper.get(member.getEmail());
        System.out.println(member2);

        int exists = memberMapper.exists(member.getEmail());
        System.out.println(exists);
    }
}
