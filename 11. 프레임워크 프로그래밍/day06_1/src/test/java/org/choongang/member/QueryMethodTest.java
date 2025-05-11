package org.choongang.member;

import org.choongang.global.configs.AppCtx;
import org.choongang.global.member.entities.Member;
import org.choongang.global.member.repositories.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringJUnitConfig(AppCtx.class)
public class QueryMethodTest {

    @Autowired
    private MemberRepository repository;

    @Test
    void test01() {
        Member member = repository.findByEmail("user9999@test.org")
                .orElseThrow(RuntimeException::new);
        System.out.println(member);
    }

    @Test
    void test02() {
        LocalDateTime today = LocalDate.now().atStartOfDay();
//        List<Member> members = repository.findByRegDtBetween(today.minusWeeks(1L), today);
//        members.forEach(System.out::println);

        // 조건 여러개 추가 가능
        //Pageable pageable = PageRequest.of(0, 2);
        Pageable pageable = PageRequest.of(1, 2, Sort.by(Sort.Order.desc("seq"), Sort.Order.asc("email")));
        Page<Member> data = repository.findByRegDtBetween(today.minusWeeks(1L), today, pageable);
        List<Member> items = data.getContent();
        long total = data.getTotalElements(); // 전체 레코드 개수
        int pages = data.getTotalPages();

        System.out.printf("total: %d, pages: %d%n", total, pages);
        items.forEach(System.out::println);
    }

    @Test
    void test03() {
        LocalDateTime today = LocalDate.now().atStartOfDay();
        List<Member> members = repository.findByRegDtBetweenAndEmailContainingOrderBySeqDesc(today.minusWeeks(1L), today, "user");
        members.forEach(System.out::println);
    }

    @Test
    void test04() {
        LocalDateTime today = LocalDate.now().atStartOfDay();
        List<Member> members = repository.getMembers(today.minusWeeks(1L), today, "%user%");
        members.forEach(System.out::println);
    }
}
