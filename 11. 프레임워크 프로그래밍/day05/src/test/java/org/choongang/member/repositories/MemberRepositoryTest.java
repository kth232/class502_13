package org.choongang.member.repositories;

import org.choongang.config.MvcConfig;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable; //패키지 확인 필수
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.List;

import static org.springframework.data.domain.Sort.Order.asc; //정적 내부 클래스 import해오는 형태로 많이 사용함
import static org.springframework.data.domain.Sort.Order.desc;

@SpringJUnitWebConfig
@ContextConfiguration(classes = MvcConfig.class) //구현체를 다 만들어줘서 가져다 쓰기만 하면 됨
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository repository;

    @Test
    void test01() {
        List<Member> members = (List<Member>) repository.findAll();
        members.forEach(System.out::println);
    }

    @Test
    void test02() {
        Member member = Member.builder()
                .seq(1L)
                .email("user01@test.org")
                .password("12345678")
                .userName("user99")
                .build();
        repository.save(member); //sql문 없이 메서드로 DB 작업 가능
        //save(): 있는 거면 만들고, 없으면 수정해줌
    }

    @Test
    void test03() {
        Member member = repository.findById(1L).orElse(null);
        //알아서 카멜케이스 표기법으로 매칭됨, select문으로 바뀜
        //Optional, null에 대한 처리를 주로 하기 때문
        System.out.println(member);

        repository.delete(member);
    }
    
    @Test
    void test04() {
        Member member = repository.findByEmail("user02@test.org");
        System.out.println(member);
        //쿼리 자동 완성, 조건절까지 생성됨
        //스프링 데이터 계열은 동작 방식이 비슷함
    }

    @Test
    void test05() {
        Pageable pageable = PageRequest.of(0, 10);
        //of()를 가장 많이 사용함
        Page<Member> members = repository.findByUserNameContaining("user", pageable);
        //members.forEach(System.out::println);
        //like ? offset 0 rows fetch.. 이라고 나오는 부분이 있으면 맞게 된 것!
    }

    @Test
    void test06() {
        List<Member> members = repository.findByUserNameContainingAndEmailContainingOrderByRegDtDesc("user", "user");
        members.forEach(System.out::println);
    }

    @Test
    void test07() {
        List<Member> members = repository.getMembers("%user%", "%user%");
        members.forEach(System.out::println);
    }
    
    @Test
    void test08() {
        //Pageable pageable = PageRequest.of(0, 3); //페이지는 0부터 시작, 3개씩 한 페이지
        Pageable pageable = PageRequest.of(0, 3, Sort.by(desc("regDt"), asc("email"))); 
        //Sort.by(Sort.Order.desc("regDt")) <-원래 식
        //Order는 Sort의 정적 내부 클래스, entities에 있는 값으로 속성을 넣어주는 것이 좋다.
        //정적 내부 클래스 import해오는 형태로 많이 사용함
        Page<Member> data = repository.findByUserNameContaining("user", pageable);

        List<Member> members = data.getContent(); //페이지 개수

        long total = data.getTotalElements(); //조회된 전체 레코드 개수
        int pages = data.getTotalPages();

        members.forEach(System.out::println);
        System.out.printf("total: %d, pages: %d%n", total, pages);
    }
}
