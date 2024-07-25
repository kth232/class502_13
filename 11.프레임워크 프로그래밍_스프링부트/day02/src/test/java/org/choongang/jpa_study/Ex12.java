package org.choongang.jpa_study;

import com.querydsl.core.Tuple; //튜플은 querydsl 패키지 사용
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.board.entities.BoardData;
import org.choongang.board.entities.HashTag;
import org.choongang.board.entities.QBoardData;
import org.choongang.board.repositories.BoardDataRepository;
import org.choongang.board.repositories.HashTagRepository;
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
@ActiveProfiles("test")
@Transactional //정상 데이터 추출을 위함
public class Ex12 {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private JPAQueryFactory queryFactory;

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

        List<BoardData> items = IntStream.range(1, 6) //게시글 5개 생성
                .mapToObj(i->BoardData.builder()
                        .subject("title" + i)
                        .content("content" + i)
                        .member(member) //태그를 먼저 등록하고 포함해서 게시글을 등록해야 외래키 넣어짐
                        .build()).toList();

        boardDataRepository.saveAllAndFlush(items);

        em.clear();
    }

    @Test
    @DisplayName("지연 실행 문제점")
    void test01() {
        List<BoardData> items = boardDataRepository.findAll();

        for (BoardData item : items) {
            Member member = item.getMember();
            String email = member.getEmail();
            String userName = member.getUserName();
            System.out.printf("email=%s, userName=%s%n", email, userName);
        }
    }

    @Test
    @DisplayName("@Query 사용")
    void test02() { //2차 쿼리 형태로 쿼리 실행
        List<BoardData> items = boardDataRepository.getAllList();
    }

    @Test
    @DisplayName("쿼리 메서드 사용시 EntityGraph")
    void test03() {
        List<BoardData> items = boardDataRepository.findBySubjectContaining("title");
    }

    @Test
    @DisplayName("querydls의 fetchJoin()")
    void test04() {
        QBoardData boardData = QBoardData.boardData;

        //JPAQueryFactory factory = new JPAQueryFactory(em); //자주 사용하는 경우 빈 객체 의존성 주입

        JPAQuery<BoardData> query = queryFactory
                .selectFrom(boardData)
                .leftJoin(boardData.member) //조인 명시 가능, qmember에서 직접 가져오면 안됨->boardData의 member 데이터를 가져와야 함
                .fetchJoin(); //fetchJoin 명시, 처음부터 조인함

        List<BoardData> items = query.fetch();
        items.forEach(System.out::println);
    }
    
    @Test
    @DisplayName("일부 컬럼만 조회")
    void test05() { //일부 컬럼만 조회할 경우 비영속 상태가 됨, 튜플 타입으로 제공됨
        QBoardData boardData = QBoardData.boardData;
        JPAQuery<Tuple> query = queryFactory
                .select(boardData.subject, boardData.content).from(boardData);
        //자료형이 2개 이상일 때 튜플형으로 받아서 형변환하기-> 어떤 타입을 쓸지 헷갈리기 때문
        List<Tuple> items = query.fetch();
        for (Tuple item : items) {
            String subject = item.get(boardData.subject);
            String content = item.get(boardData.content);
            System.out.printf("subject=%s, content=%s%n", subject, content);
        }
    }

    @Test
    void test06() {
        QBoardData boardData = QBoardData.boardData;
        JPAQuery<Long> query = queryFactory.select(boardData.seq.sum())
                .from(boardData);
    }
    
}
