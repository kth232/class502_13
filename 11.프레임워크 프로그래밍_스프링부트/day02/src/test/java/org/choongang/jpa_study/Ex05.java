package org.choongang.jpa_study;

import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active = test")
public class Ex05 {

    @Autowired //스프링이 구현체 생성해줌, 프록시 객체
    private MemberRepository memberRepository;

    @BeforeEach
    void init() {
        //리스트 형태로 멤버 생성
        List<Member> members = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> Member.builder()
                        .email("user" + i + "@test.org")
                        .password("12345678")
                        .userName("user" + i)
                        .authority(Authority.USER)
                        .build()).toList();

        memberRepository.saveAllAndFlush(members);

        /*
        for (int i =1; i<=10; i++) {
            Member member = Member.builder()
                    .email("user01@test.org")
                    .password("12345678")
                    .userName("user01")
                    .authority(Authority.USER)
                    .build();

            memberRepository.save(member);
        }
        memberRepository.flush();

        //memberRepository.saveAndFlush(member); //save하고 flush하는 과정을 한번에 수행

        //memberRepository.save(member); //죄회하려면 데이터가 반영되야 하기 때문에 암묵적으로 flush가 수행됨
        //memberRepository.flush();
        */
    }
    
    @Test
    void test01() {
        Member member = memberRepository.findById(1l).orElse(null); //기본키로 조회
        System.out.println(member);

        member.setUserName("(mod)user01"); //엔티티에 변화가 있기 때문에 암묵적으로 flush가 수행됨, 조회 시 최종 결과를 보여줘야 하기 때문
        memberRepository.save(member); //save해줘야 update됨

        Member member2 = memberRepository.findById(1l).orElse(null); //기본키로 조회
        System.out.println(member2);

        memberRepository.delete(member2);
        memberRepository.flush();
    }

    @Test
    void test02() {
        List<Member> members = memberRepository.findAll(); //전체 데이터 조회, 영속 상태이기 때문에 변화 감지됨
        members.forEach(System.out::println);
    }
}
