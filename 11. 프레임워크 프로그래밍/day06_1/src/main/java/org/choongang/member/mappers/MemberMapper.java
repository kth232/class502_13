package org.choongang.member.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.choongang.global.CommonSearch;
import org.choongang.member.entities.Member;

import java.util.List;
import java.util.Optional;

public interface MemberMapper {
    List<Member> getList();
//    Member get(String email);
//    Optional<Member> get(@Param("email") String email, @Param("seq") long seq); // 값이 null일때 처리가 필요한 경우

    Optional<Member> get(String email);

    int register(Member member);
    int update (Member member);
    int delete(String email);

    List<Member> getList2(List<Long> seqs);

    //간단한 sql인 경우 mapper.xml에 정의하지 않고 바로 사용 가능
    @Select("SELECT COUNT(*) FROM member")
    long getTotal();

    @Select("SELECT COUNT(*) FROM member WHERE CONCAT(email, name, mobile) LIKE #{keyword}")
    long getTotal2(String keyword);

    List<Member> getList(CommonSearch search);
}

