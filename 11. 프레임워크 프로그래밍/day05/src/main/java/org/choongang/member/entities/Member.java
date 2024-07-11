package org.choongang.member.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor //기본 생성자 필요
//@Table("Member") //테이블명이 다를 경우 명시해주면 됨, 직접 테이블 만들어야 함
public class Member {
    
    @Id //ID값 필수설정 ->명시해야 함
    //@Column("ID") //컬럼명도 동일해야 함
    private Long seq; //(어짜피 바뀌긴 하지만)wrapper 클래스로 감쌈<-제네릭에 넣기 위함(기본형 안됨)
    private String email;
    private String password;
    private String userName;
    private LocalDateTime regDt;
}
