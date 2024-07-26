package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.board.entities.BoardData;
import org.choongang.board.entities.HashTag;
import org.choongang.board.repositories.BoardDataRepository;
import org.choongang.board.repositories.HashTagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Transactional //양쪽에서 조회하는 경우 영속성 유지되어야 하기 때문에 트랜잭션 사용
@ActiveProfiles("test") //테스트 DB 사용
public class Ex11 { //오라클 DB에 실제로 값 들어가는 것 확인->test 설정 x->환경변수 설정 필수
    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private HashTagRepository hashTagRepository;

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        List<HashTag> tags = IntStream.range(1, 4) //태그 3개 생성
                .mapToObj(i->HashTag.builder()
                        .tag("tag" + i)
                        .build()).toList();

    hashTagRepository.saveAllAndFlush(tags);

    List<BoardData> items = IntStream.range(1, 6) //게시글 5개 생성
            .mapToObj(i->BoardData.builder()
                    .subject("title" + i)
                    .content("content" + i)
                    //.tags(tags) //태그를 먼저 등록하고 포함해서 게시글을 등록해야 외래키 넣어짐
                    .build()).toList();

    boardDataRepository.saveAllAndFlush(items);

    em.clear();
    }

    @Test
    @DisplayName("manyToMany 테스트_게시글->태그")
    void test01() {
        BoardData items = boardDataRepository.findById(1L).orElse(null);

//        List<HashTag> tags = items.getTags();
//        tags.forEach(System.out::println);
    }
    
    @Test
    @DisplayName("manyToMany 테스트_태그->게시글")
    void test02() {
        HashTag tag = hashTagRepository.findById("tag2").orElse(null);

//        List<BoardData> items = tag.getItems(); //태그에서 게시글 정보 가져오긴
//        items.forEach(System.out::println);
    }
}
