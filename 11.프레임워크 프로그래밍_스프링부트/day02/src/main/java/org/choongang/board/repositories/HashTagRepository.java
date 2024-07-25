package org.choongang.board.repositories;

import org.choongang.board.entities.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashTagRepository extends JpaRepository<HashTag, String> {
    //querydslpredicateExcutor 상속 안함
}
