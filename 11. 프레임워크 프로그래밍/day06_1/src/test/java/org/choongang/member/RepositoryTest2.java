package org.choongang.member;

import org.choongang.global.configs.AppCtx;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.domain.Sort.Order.asc;
import static org.springframework.data.domain.Sort.Order.desc;

@SpringJUnitConfig(AppCtx.class)
public class RepositoryTest2 {

    @Autowired
    private MemberRepository repository;

    @Test
    void test1() {
        LocalDateTime sDate = LocalDateTime.now().minusDays(15L);
        LocalDateTime eDate = LocalDateTime.now();

        //Pageable pageable = PageRequest.of(0, 4); // 1 - 2페이지 2개 레코드
        Pageable pageable = PageRequest.of(0, 4, Sort.by(desc("regDt"), asc("email")));

        Page<Member> data = repository.findByRegDtBetween(sDate, eDate, pageable);
        List<Member> items = data.getContent();
        long total = data.getTotalElements();

        items.forEach(System.out::println);
        System.out.println("total:" + total);
    }
}
