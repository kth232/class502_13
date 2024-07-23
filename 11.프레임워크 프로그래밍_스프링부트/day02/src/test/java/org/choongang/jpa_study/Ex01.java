package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest //테스트
@Transactional //트랜잭션 자동 처리
@TestPropertySource(properties = "spring.profiles.active=test") //propertySource=설정 파일, application-test.yml 사용
public class Ex01 {

    //@Autowired
    //private EntityManagerFactory emf;

    //@Autowired
    @PersistenceContext //의존성 주입, 의미적으로 더 적합함
    private EntityManager em; //영속성 관리자 역할

    @Test
    void test01() {
        //EntityManager em = emf.createEntityManager();
        
        //EntityTransaction tx = em.getTransaction(); //트랜잭션 수동 관리 필요->@Transactional로 자동 처리
        //tx.begin(); // transaction 시작

        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setPassword("12345678");
        member.setUserName("user01");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member); //영속상태->member 엔티티가 변화감지 메모리에 담김->자동 쿼리 수행
        //엔티티 매니저가 영속성 상태로 만들어줌, 관리 영역에 넣어준다

        em.flush(); //DB 반영, INSERT 쿼리

        em.detach(member); //영속 상태 분리=관리 받지 않음->변화 감지 x

        member.setUserName("(mod)user01"); //영속성 안에 있으면서 값이 바뀜->변경
        member.setModifiedAt(LocalDateTime.now());

        em.flush(); //DB 반영, UPDATE 쿼리

        em.merge(member); //분리된 영속 상태 -> 영속 상태로(변화 감지 상태)
        //엔티티의 변화 유무를 확인하기 위해 DB에서 데이터를 가져와 엔티티와 비교함
        //비교 시 수정사항이 있다면 위의 쿼리를 수행해서 수정사항이 늦게라도 반영된다

        em.flush();

//        em.remove(member); //제거 상태, 실제 제거 x, 상태만 변경
//        em.flush(); //DELETE 쿼리

        //tx.commit();
    }
}
