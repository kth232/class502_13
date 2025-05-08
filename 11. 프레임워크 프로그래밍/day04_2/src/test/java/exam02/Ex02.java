package exam02;

import org.choongang.configs.AppCtx;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(AppCtx.class)
public class Ex02 {
    @Autowired
    private MemberRepository repository;

    @Test
    void test1() {
        List< Member> items = repository.findAll();
        items.forEach(System.out::println);
    }
}
