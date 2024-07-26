package org.choongang.jpa_study;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple; //튜플은 querydsl 패키지 사용
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.aspectj.weaver.ast.Or;
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
    @DisplayName("JPAquery_통계관련 기능 연습")
    void test06() {
        QBoardData boardData = QBoardData.boardData;
        JPAQuery<Long> query = queryFactory.select(boardData.seq.sum()) //순번 합계 구하기
                .from(boardData);

        long sum = query.fetchOne(); //값이 1개만 있을 때 사용
        System.out.println(sum);
    }

    @Test
    @DisplayName("booleanBuilder로 조건 추가")
    void test07() {
        QBoardData boardData = QBoardData.boardData;

        BooleanBuilder andBuilder = new BooleanBuilder(); //and빋러
        andBuilder.and(boardData.subject.contains("title"))
                .and(boardData.member.email.eq("user01@test.org"));

        /*
        //or빌더->조건이 꼬일 수 있기 때문에 and빌더 내부에 포함시키는 것이 좋다
        BooleanBuilder orBuilder = new BooleanBuilder(); 
        orBuilder.or(boardData.seq.eq(2L))
                .or(boardData.seq.eq(3L))
                .or(boardData.seq.eq(4L));

        andBuilder.and(orBuilder); //in 조건을 사욯하는 것이 더 좋지만 or빌더 연습용으로 작성함
        */
        
        PathBuilder<BoardData> pathBuilder = new PathBuilder<>(BoardData.class, "boardData"); 
        //class 클래스로 정보 확인->reflectioin api 사용
        
        

        JPAQuery<BoardData> query = queryFactory.selectFrom(boardData) //selectForm->영속상태로 데이터 가져옴
                .leftJoin(boardData.member)
                .fetchJoin()
                .where(andBuilder) //빌더를 통해 조건 추가
                .offset(3) //조회 시작 레코드 위치, 3번 행부터 조회 시작
                .limit(3) //출력 개수 제한=3개 레코드로 한정
                .orderBy(
                        new OrderSpecifier(Order.DESC, pathBuilder.get("createdAt")), //comparable: 기본 정렬 기준, 정렬 순서는 enum 상수 사용
                        new OrderSpecifier(Order.ASC, pathBuilder.get("subject"))
                ); //정렬, pathBuilder를 통해 만든 정렬 조건 사용
                //.where(boardData.seq.in(2L, 3L, 4L)); //반환값=booleanExpression-Predicate 구현 클래스
                //or빌더보다 in연산자가 더 효울적이다

        List<BoardData> items = query.fetch(); //리스트형태의 데이터 가져오기
        items.forEach(System.out::println);
    }
}
