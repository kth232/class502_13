package org.choongang.global.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass //공통 속성으로 사용할 상위클래스에 정의
@EntityListeners(AuditingEntityListener.class) //엔티티 리스너가 변화 감지 감독
public abstract class BaseEntity { //반복되는 속성은 공통 속성 정의(편의 목적)->추상 클래스
    //테이블 컬럼 순서는 지정 불가

    @CreatedDate //스프링 표준 애노테이션 -> 추가 설정 필요, 동작 방식이 다름
    @Column(updatable = false) //처음 입력 후 수정되면 안됨
    private LocalDateTime createdAt;

    @LastModifiedDate //스프링 표준 애노테이션, 변화 감지를 통해 변경됨
    @Column(insertable = false) //수정 시에만 입력되야 함
    private LocalDateTime modifiedAt;
}