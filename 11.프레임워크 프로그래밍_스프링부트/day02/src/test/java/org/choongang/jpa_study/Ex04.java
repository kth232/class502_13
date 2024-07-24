package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex04 {

    @PersistenceContext
    private EntityManager em;

    @Test
    void test01() throws Exception {
        //날짜, 증감번호는 알아서 입력됨
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setPassword("12345678");
        member.setUserName("user01");

        em.persist(member);

        em.flush();

        em.clear(); //새로 데이터 가져오기 위함, 1차 캐시에 남아있으면 기존 데이터를 가져옴

        member = em.find(Member.class, member.getSeq());
        System.out.printf("createAt: %s, modifiedAt: %s%n", member.getCreatedAt(), member.getModifiedAt());
        //날짜 출력
        
        Thread.sleep(5000); //생성 시간, 수정 시간 5초 차이
        member.setUserName("(mod)user01");
        member.setCreatedAt(LocalDateTime.now()); //입력값이 바뀌면 안됨
        em.flush();
        em.clear();
        
        member = em.find(Member.class, member.getSeq());
        System.out.printf("createAt: %s, modifiedAt: %s%n", member.getCreatedAt(), member.getModifiedAt());
    }
}
