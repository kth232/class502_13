package org.choongang.global.configs;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@RequiredArgsConstructor
public class DBConfig {

    @PersistenceContext
    private EntityManager em;

    @Lazy //필요할 때 생성해서 공유, 로딩 빠름
    @Bean //자주 사용하는 경우 스프링 관리 객체로 만든다.
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(em);
    }
}
