package org.choongang.member;

import org.choongang.global.configs.AppCtx;
import org.choongang.global.member.entities.Member;
import org.choongang.global.member.repositories.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDateTime;
import java.util.List;

@SpringJUnitConfig(AppCtx.class)
public class RepositoryTest {

    @Autowired
    private MemberRepository repository;

    @Test
    void test01() {
        List<Member> members = repository.findAll();
        members.forEach(System.out::println);
    }

    @Test
    void test02() {
        Member member = repository.findById(3L).orElse(null);
        System.out.println("member: " + member);

        List<Member> members = repository.findAllById(List.of(2L, 3L));
        members.forEach(System.out::println);
    }

    @Test
    void test03() {
        Member member = new Member();
        member.setEmail("user9999@test.org");
        member.setPassword("12345678");
        member.setName("user9999");
        member.setMobile("010-0000-0000");
        member.setTerms(true);

        member = repository.save(member);
        System.out.println(member);
    }

    @Test
    void test04() {
        Member member = repository.findById(12L).orElse(null);
//        member.setName("(수정)user9999");
        member.setRegDt(LocalDateTime.now());

        repository.save(member); //UPDATE

        Member member2 = repository.findById(12L).orElse(null);
        System.out.println("member: " + member2);
    }
}