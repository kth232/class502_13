package org.choongang.jpa_test;

import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
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
public class BoardTest {
    @Autowired
    private BoardDataRepository boardDataRepository;

    @BeforeEach
    void init() {
        List<BoardData> boards = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> BoardData.builder()
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
