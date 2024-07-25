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
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class Ex09 {
    //관계 매핑, 지연 로딩 시 원래 데이터의 영속성이 끝났기 때문에 데이터를 못 가져오는 경우가 있음
    //->트랜잭션 설정으로 원래 데이터의 영속성 유지시켜줘야 함
    //영속성 관리에 중점

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

        List<BoardData> items = IntStream.range(1, 5)
                        .mapToObj(i -> BoardData.builder()
                                .subject("title" + i)
                                .content("content" + i)
                                .member(member) //멤버 seq를 외래키로 넣어주기 위해 필수 입력
                                .build()).toList();

        boardDataRepository.saveAllAndFlush(items);
        em.clear();
        //영속성을 비우지 않으면 영속성 상태에 있는 기존 데이터를 가져올 수도 있다(캐시, 성능의 이점)
        //-> 실제 개발할 때는 적극적으로 활용
        //예제에서는 명확하게 데이터를 가져오는 걸 확인하기 위해 영속성을 비워준다
    }

    @Test
    @DisplayName("연관 관계 매핑 ManyToOne")
    void test01() {
        BoardData item = boardDataRepository.findById(1L).orElse(null);

        Member member = item.getMember(); //게시글을 작성한 회원 정보도 알 수 있다

        System.out.println(item);

    }

    @Test
    @DisplayName("연관 관계 매핑 OneToMany")
    void test02() {
        Member member = memberRepository.findById(1L).orElse(null);

        List<BoardData> items = member.getItems(); //지연 로딩 적용 중, 멤버 데이터만 출력하고 조인은 아직 안됨
        //멤버에서 게시글 데이터는 꼭 필요하지 않음, 필요할 때만 불러오면 됨->지연로딩

        items.forEach(System.out::println); //items를 출력해야 조인됨
        //회원번호를 가지고 2차 쿼리 수행함->게시글 조회

        //lombok은 getter 메서드를 통해 toString()으로 호출->순환참조 발생
        //member쪽의 연결 끊어줌(member에게 게시글 데이터는 상대적으로 중요도 낮음)->ToString.Exclude
        //member의 ToString.Exclude 때문에 member 데이터는 출력 x
    }
}
