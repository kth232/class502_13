package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {
    //<객체 자료형, 기본키 자료형>, 기본 자료형 사용 불가->wrapper 클래스 사용(변환 작업 필요x)
    //QuerydslPredicateExecutor<Member> 상속 추가->querydsl 사용 위함

    //쿼리 메서드, 엔티티 기준 쿼리, 간단한 쿼리만 작성
    // 필요한 경우 Optional<Member> 가능
    Member findByEmail(String email); //정석은 findMemberBy..지만 Member에서 조회할 것을 알기 때문에 Member 생략 가능

    Page<Member> findByEmailContaining(String keyword, Pageable pageable);
    //쿼리 메서드의 매개변수로 pageable, 정렬 추가 가능
    //pageable을 사용하면 반환값 page 타입으로 사용해야 함

    List<Member> findByEmailContainingAndUserNameContainingOrderByCreatedAtDesc(String key1, String key2);
    //조건이 많아지면 메서드명 길어짐

    //쿼리 애노테이션
    @Query("SELECT m FROM Member m WHERE m.email LIKE :k1 AND m.userName LIKE :k2 ORDER BY m.createdAt DESC") //전체 조회 시에만 영속 상태가 됨
    List<Member> getMembers(@Param("k1") String key1, @Param("k2") String key2);
    //문법상 오류가 있어도 실행해봐야 알 수 있음, 오류를 잘 알려주지 않음, 쿼리 직접 입력하는 것 지양
    //쿼리 빌딩 시 조회가 주 목적


}
