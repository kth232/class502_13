package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.springframework.data.repository.ListCrudRepository;

public interface MemberRepository extends ListCrudRepository<Member, Long> {
}
