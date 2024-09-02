package org.choongang.jpa_test;

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
import java.util.stream.LongStream;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class BoardTest {
    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init() {

        Member member = Member.builder()
                        .email("user@test.org")
                        .password("12345678")
                        .userName("user")
                        .authority(Authority.USER)
                        .build();

        memberRepository.saveAndFlush(member);

        List<BoardData> boards = LongStream.rangeClosed(1, 5)
                .mapToObj(i -> BoardData.builder()
                        .seq(i) //게시글 번호
                        .member(member)
                        .subject("title"+i)
                        .content("content" +i)
                        .build()).toList();

        boardDataRepository.saveAllAndFlush(boards);
    }

    @Test
    @DisplayName("게시글 조회")
    void test01() {
        List<BoardData> boardData = boardDataRepository.findBySubjectContaining("title");
        System.out.println(boardData);

        List<BoardData> items = boardDataRepository.getAllList();
        System.out.println(items);
    }

    @Test
    @DisplayName("게시글 수정")
    void test02() {
        BoardData boardData = boardDataRepository.findById(1L).orElse(null);
        System.out.println(boardData);

        boardData.setSubject("(mod)title01");
        boardData.setContent("(mod)content01");
        boardDataRepository.saveAndFlush(boardData);

        List<BoardData> items = boardDataRepository.findAll();
        items.forEach(System.out::println);
    }

    @Test
    @DisplayName("게시글 삭제")
    void test03() {
        BoardData item1 = boardDataRepository.findById(1L).orElse(null);
        System.out.println(item1);

        boardDataRepository.delete(item1);
        boardDataRepository.flush();

        List<BoardData> items = boardDataRepository.findAll();
        items.forEach(System.out::println);
    }
}
