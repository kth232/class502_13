package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest //다른 의존성 추가할 필요 없이 테스트 가능
@Transactional
//@TestPropertySource(locations="classpath:application.yml") //location 속성 사용
public class Ex03 {

    @PersistenceContext
    private EntityManager em;

    @Test
    void test01() {
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setPassword("12345678");
        member.setUserName("user01");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member);

        Member member2 = new Member();
        member2.setEmail("user02@test.org");
        member2.setPassword("12345678");
        member2.setUserName("user02");
        member2.setCreatedAt(LocalDateTime.now());

        em.persist(member2);

        em.flush();

        em.clear(); //영속성 비우기

        Member _member1 = em.find(Member.class, member.getSeq());
        System.out.println(_member1);

        Member _member2 = em.find(Member.class, member2.getSeq());
        System.out.println(_member2);
    }
}
