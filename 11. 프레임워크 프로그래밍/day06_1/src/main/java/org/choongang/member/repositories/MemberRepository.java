package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends ListCrudRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    
    //페이징 추가 -> 반환값 Page
    Page<Member> findByRegDtBetween(LocalDateTime sdate, LocalDateTime edate, Pageable pageable);

    List<Member> findByRegDtBetweenAndEmailContainingOrderBySeqDesc(LocalDateTime sdate, LocalDateTime edate, String email);

    @Query("SELECT * FROM member WHERE regDt BETWEEN :sdate AND :edate AND email LIKE :keyword ORDER BY seq DESC")
    List<Member> getMembers(@Param("sdate") LocalDateTime sdate,
                            @Param("edate") LocalDateTime edate,
                            @Param("keyword") String email);
}
