package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.entities.MemberProfile;
import org.choongang.member.repositories.MemberProfileRepository;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional //관계 매핑, 지연 로딩이 있을 땐 트랜잭션 관리 필수->영속성 데이터 값 유지하기 위함
public class Ex10 {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberProfileRepository profileRepository;

    @PersistenceContext
    private EntityManager em;
    //쿼리 확인하기 위해 clean으로 영속성 비워줌
    //아니면 캐시에 저장된 값 가져올 수 있기 때문에 확인 어려움
    //실제로는 캐시 장점 적극적으로 사용

    @BeforeEach
    void init() {
        MemberProfile profile = MemberProfile.builder()
                .profileImage("image1")
                .status("status200")
                .build();
        profileRepository.saveAndFlush(profile);

        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345678")
                .userName("user01")
                .authority(Authority.USER)
                .profile(profile) //프로필을 먼저 등록하고 포함해서 멤버를 등록해야 외래키 넣어짐
                .build();
        memberRepository.saveAndFlush(member);

        em.clear();
    }

    @Test
    @DisplayName("일대일 관계 매핑 테스트_멤버->프로필")
    void test01() {
        Member member = memberRepository.findById(1L).orElse(null);
        //프로필이 없어도 회원정보가 나올 수 있게 left join

        MemberProfile profile = member.getProfile();
        System.out.println(profile);
    }

    @Test
    @DisplayName("일대일 관계 매핑 테스트_프로필->멤버")
    void test02() {
        MemberProfile profile = profileRepository.findById(1L).orElse(null);
        Member member = profile.getMember(); //프로필에서 멤버 정보 가져오기, 순환참조 발생->프로필에서 연결 끊음
        System.out.println(member);
    }
}
