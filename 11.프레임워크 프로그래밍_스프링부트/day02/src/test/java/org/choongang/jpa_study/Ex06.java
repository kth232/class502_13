package org.choongang.jpa_study;

import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex06 {

    @Autowired
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
    }

    @Test
    void test01() {
        //쿼리 메서드 사용, 엔티티 기준 쿼리
        Member member = memberRepository.findByEmail("user2@test.org");
        System.out.println(member);
    }

    @Test
    @DisplayName("쿼리 메서드 사용") //테스트 결과에 설정한 이름으로 출력하기
    void test02() {
        List<Member> members = memberRepository
                .findByEmailContainingAndUserNameContainingOrderByCreatedAtDesc("ser", "ser");
        members.forEach(System.out::println);
    }

    @Test
    @DisplayName("Pageable 사용") //테스트 결과에 설정한 이름으로 출력하기
    void test03() {
        Pageable pageable = PageRequest.of(0, 3); //0번부터 3개씩 꺼냄
        Page<Member> data = memberRepository.findByEmailContaining("ser", pageable);

        List<Member> items = data.getContent(); //조회된 데이터 가져오기
        long total = data.getTotalElements(); //전체 데이터 개수

        System.out.printf("total %d\n", total);
        items.forEach(System.out::println);
    }

    @Test
    @DisplayName("@Query 사용") //테스트 결과에 설정한 이름으로 출력하기
    void test04() {
        List<Member> members = memberRepository.getMembers("%ser%", "ser");
        members.forEach(System.out::println);
    }
}
