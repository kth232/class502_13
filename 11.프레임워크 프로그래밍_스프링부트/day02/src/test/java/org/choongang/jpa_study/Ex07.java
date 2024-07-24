package org.choongang.jpa_study;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.entities.QMember;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex07 {

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
                        .authority(i % 2 == 0 ? Authority.USER: Authority.ADMIN) //조건식 가능
                        .build()).toList();

        memberRepository.saveAllAndFlush(members);
    }

    @Test
    @DisplayName("queryDsl 사용")
    void test01() {
        QMember member = QMember.member;
        //판별식, 조건식=where절
        BooleanExpression c1 = member.userName.contains("ser");

        List<Member> members = (List<Member>) memberRepository.findAll(c1); //형변환

        members.forEach(System.out::println);
    }

    @Test
    @DisplayName("booleanBuilder 사용")
    void test02() {
        String key = "ser";
        QMember member = QMember.member;
        BooleanBuilder andBuilder = new BooleanBuilder();//and조건으로 자동 완성, 메서드 체이닝 의도
        BooleanBuilder orBuilder = new BooleanBuilder(); //or조건으로 자동 완성

        orBuilder.or(member.email.contains(key)) //다양한 조건 처리 가능
                .or(member.userName.contains(key));

        //or조건은 다른 조건에 간섭 가능성 있음->명확하게 구분 시 소괄호로 묶어주기, and조건과 함께 사용
        andBuilder.and(orBuilder);

        List<Member>members = (List<Member>)memberRepository.findAll(andBuilder);
        members.forEach(System.out::println);
    }

    @Test
    @DisplayName("concat 형태로 결합한 쿼리 빌딩")
    void test03() {
        QMember member = QMember.member;
        BooleanExpression c1 = member.email.concat(member.userName).contains("ser");
        //컬럼과 키워드 결합

        List<Member> members = (List<Member>) memberRepository.findAll(c1);
        members.forEach(System.out::println);
    }
}
