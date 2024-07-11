package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; //springframework.data로 import
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param; //repository의 param으로 import

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {
    //구현체를 알아서 만들어주고 쿼리도 패턴에 맞게 만들어줌
    //간단한 쿼리일 때 위주로 사용, 조건을 많이 걸면 메서드명이 길고 복잡해진다.
    Member findByEmail(String email);
    Page<Member> findByUserNameContaining(String keyword, Pageable pageable); //pageable을 매개변수로 넣으면 알아서 인식함
    //하나는 전체 개수, 하나는 목록 -> 2번 수행
    List<Member> findByUserNameContainingAndEmailContainingOrderByRegDtDesc(String key1, String key2);

    @Query("SELECT * FROM MEMBER WHERE USER_NAME LIKE :param1 AND EMAIL LIKE :param2 ORDER BY REG_DT DESC")
    List<Member> getMembers(@Param("param1") String key1, @Param("param2") String key2);
    //복잡한 쿼리는 직접 입력하도록 하는 @Query
}
