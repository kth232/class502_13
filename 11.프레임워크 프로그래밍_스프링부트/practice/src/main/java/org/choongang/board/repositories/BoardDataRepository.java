package org.choongang.board.repositories;

import org.choongang.board.entities.BoardData;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>, QuerydslPredicateExecutor {
    //인터페이스로 만들어야 함, 자바 표준 프록시 인터페이스로 알아서 구현체 생성해줌
    //querydsl 사용하기 위해 QuerydslPredicateExecutor 상속, 쿼리 빌더로 오타 방지
    //predicate 매개변수로 조건식 다양하게 사용 가능

    //fetch 조인 = 즉시 조인
    @Query("SELECT b FROM BoardData b LEFT JOIN FETCH b.member") //직접 쿼리 작성 시 오타 문제 가능성
    List<BoardData> getAllList();

    //해당 항목으로 즉시 조인됨
    //바로 조인할 엔티티 명시, 게시글 속성 중에서 member를 의미(속성명), 배열형으로 입력 시 중괄호로 작성
    @EntityGraph(attributePaths = {"member"})
    List<BoardData> findBySubjectContaining(String key); //쿼리 메서드에 한정해서 사용 가능
}