package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.PersistenceContext;
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

@SpringBootTest
@ActiveProfiles("test") //프로필 설정 파일 가져오는 애노테이션, 값에 해당하는 설정 파일로 적용
public class Ex08 {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init() {
        em.setFlushMode(FlushModeType.AUTO); //flush 모드를 auto로 바꿔줌, 설정 활성화 따로 해줘야 함

        Member member = Member.builder() //@generatedValue로 seq 자동 부여, 오히려 추가 입력하면 오류 발생함
                .email("user01@test.org")
                .password("12345678")
                .userName("user01")
                .authority(Authority.USER)
                .build(); //baseEntity로 자동 날짜, 시간 추가

        memberRepository.saveAndFlush(member);

        em.clear(); //영속성 비우기 -> 쿼리 수행
    }

    @Test
    @DisplayName("flush 오류 해결")
    void Test01() {
        Member member = memberRepository.findById(1L).orElse(null);

        member.setUserName("test!");

        List<Member> members = memberRepository.findAll(); //전체 조회
        members.forEach(System.out::println);

        em.clear();

        Member member2 = memberRepository.findById(1L).orElse(null);
    }
}
