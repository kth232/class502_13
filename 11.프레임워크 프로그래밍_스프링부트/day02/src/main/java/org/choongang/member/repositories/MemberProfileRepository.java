package org.choongang.member.repositories;

import org.choongang.member.entities.MemberProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MemberProfileRepository extends JpaRepository<MemberProfile, Long>, QuerydslPredicateExecutor {

}
