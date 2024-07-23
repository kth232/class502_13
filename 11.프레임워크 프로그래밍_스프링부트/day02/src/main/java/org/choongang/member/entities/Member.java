package org.choongang.member.entities;

import jakarta.persistence.*; //entity, table등을 지원하는 패키지명 주의,
import lombok.Data;
import org.choongang.member.constants.Authority;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity //JPA가 관리하는 데이터, 해당 데이터를 바탕으로 테이블이 만들어짐, 데이터 한 행을 의미
//@Table(name="CH_MEMBER") //name 값으로 지정한 이름의 테이블이 없으면 새로 생성, 있으면 기존 테이블로 매핑
/*
@Table(indexes= {
    @Index(name="idx_created_at_desc", columnList = "createdAt DESC"), //DB가 아닌 클래스에 있는 속성으로 해야 함
    @Index(name="uq_email_passsword", columnList = "email, password", unique = true) //유니크 테이터
})*/
public class Member { //기본 엔티티명, 테이블명은 클래스명, 정의된 내용으로 테이블 생성
    //엔티티 상세하게 설정할 수 있는 애노테이션 제공

    @Id @GeneratedValue//@Id=기본키 설정(필수) @GeneratedValue(strategy = GenerationType.AUTO)=기본값, 자동 증감
    private Long seq;
    private String email;
    private String password;
    private String userName;

    //@Lob //->Clob 형태로 만들어짐
    @Transient //매핑 무시->DB 반영이 아니라 내부적으로 사용(데이터 2차 가공 등)할 목적일 때
    private String introduction;

    @Enumerated(EnumType.STRING) //테이블 컬럼으로 들어옴, 상수로 정의했는데 number형으로 들어옴->기본값이 ordinal->상수 번호로 출력
    private Authority authority; //ordinal로 들어오면 문제점이 많기 때문에 String으로 값을 넣을 수 있게 해야 함

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp //내부적으로 데이터 들어감?
    private LocalDateTime modifiedAt;

}
