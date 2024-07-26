package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class Ex13 {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardDataRepository boardDataRepository;

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345678")
                .userName("user01")
                .authority(Authority.USER)
                .build();

        memberRepository.saveAndFlush(member);


        List<BoardData> items = IntStream.rangeClosed(1, 6)
                .mapToObj(i -> BoardData.builder()
                        .subject("title" + i)
                        .content("content" + i)
                        .member(member)
                        .build()).toList();

        boardDataRepository.saveAllAndFlush(items);
        em.clear();
    }

    @Test
    @DisplayName("cascade_remove")
    void test01() {
        Member member = memberRepository.findById(1L).orElse(null);
        memberRepository.delete(member);

        memberRepository.flush();
    }

    @Test
    @DisplayName("고아 객체 삭제")
    void test02() {
        Member member = memberRepository.findById(1L).orElse(null);

        List<BoardData> items = member.getItems();

        items.remove(0); //0번째 자식 객체 제거=부모 객체 자원 안에서 자식 객체를 내보내는 것=참조가 끊긴 것
        items.remove(1); //=메모리 상(리스트)에서만 제거한 것, 영속성 컨텍스트, DB에는 남아있는 상태

        memberRepository.flush(); //목록에서만 제거해도 제거됨 =영속성 컨텍스트에서도 제거
    }
}