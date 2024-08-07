package org.choongang.jpa_test;

import jakarta.transaction.Transactional;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init() {
        List<Member> members = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> Member.builder()
                        .email("user" + i + "@test.org")
                        .password("12345678")
                        .userName("user" + i)
                        .authority(Authority.USER)
                        .build()).toList();

        memberRepository.saveAllAndFlush(members);
    }

    @Test
    @DisplayName("회원 조회")
    void test1() {
        Member member = memberRepository.findByEmail("user2@test.org");
        System.out.println(member);

        List<Member> member2 = memberRepository.findAll();
        System.out.println(member2);
    }

    @Test
    @DisplayName("회원 수정")
    void test2() {
        Member member = memberRepository.findById(1L).orElse(null);
        System.out.println(member);

        member.setUserName("(mod)user01");
        memberRepository.saveAndFlush(member);

        List<Member> members = memberRepository.findAll(); //전체 회원 조회
        members.forEach(System.out::println);
    }

    @Test
    @DisplayName("회원 삭제")
    void test3() {
        Member member2 = memberRepository.findById(1L).orElse(null);
        System.out.println(member2);

        memberRepository.delete(member2);
        memberRepository.flush();

        List<Member> members = memberRepository.findAll();
        members.forEach(System.out::println);
    }
}
