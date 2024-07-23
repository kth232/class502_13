package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex02 {
    
    //@Autowired //autoWired 써도 가능
    @PersistenceContext //의미적으로 더 적합함, 의존성 주입
    private EntityManager em;
    
    @BeforeEach
    void init() {
        for(long i = 1; i <= 10; i++) {
            Member member = new Member();
            member.setSeq(i);
            member.setEmail("user"+i+"@test.org");
            member.setPassword("12345678");
            member.setUserName("user" + i);
            member.setCreatedAt(LocalDateTime.now());
            em.persist(member); //영속 상태
            //처음 만들고 처음 생성한 객체->insert 쿼리
        }
        em.flush(); //DB 영구 반영
        em.clear(); //영속 상태 엔티티 모두 비우기
    }

    @Test
    void test01() {
        Member member = em.find(Member.class, 1L);
        System.out.println(member);

        Member member2 = em.find(Member.class, 1L);
        System.out.println(member2);

        System.out.println(member == member2);
        System.out.println("member: "+ System.identityHashCode(member));
        System.out.println("member2: "+ System.identityHashCode(member2));
        
        member.setUserName("(mod)user01");
        
        //em.flush(); //UPDATE 쿼리 수행
        //값 변경 후, 삭제 상태 변경 후 해당 데이터를 조회->암묵적으로 flush()
        Member member3 = em.find(Member.class, 1L);
        System.out.println(member3);
    }
}
