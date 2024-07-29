package org.choongang.member.entities;

import jakarta.persistence.*;
import lombok.*;
import org.choongang.board.entities.BoardData;
import org.choongang.global.entities.BaseEntity;
import org.choongang.member.constants.Authority;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@AllArgsConstructor //모든 필드 값을 파라미터 값으로 받는 생성자 생성
@NoArgsConstructor //기본 생성자 생성
@Builder
@Data
@Entity //JPA가 관리하는 데이터, 해당 데이터를 바탕으로 테이블이 만들어짐, 데이터 한 행을 의미
public class Member extends BaseEntity { //기본 엔티티명, 테이블명은 클래스명, 정의된 내용으로 테이블 생성, baseEntity 상속
    //엔티티 상세하게 설정할 수 있는 애노테이션 제공

    @Id
    @GeneratedValue//@Id=기본키 설정(필수) @GeneratedValue(strategy = GenerationType.AUTO)=기본값, 자동 증감 번호
    private Long seq;

    @Column(length = 60, unique = true, nullable = false) //유니크 제약조건, not null 제약조건 추가(nullable: 필수 항목 지정)
    private String email;

    @Column(length = 65, nullable = false) //필수 항목 설정
    private String password;

    @Column(nullable = false, length = 40) //테이블 컬럼명 지정
    private String userName; //엔티티명은 userName

    @Column(length = 10) //문자열 길이 설정
    @Enumerated(EnumType.STRING) //테이블 컬럼으로 들어옴, 상수로 정의했는데 number형으로 들어옴->기본값이 ordinal->상수 번호로 출력
    private Authority authority; //ordinal로 들어오면 문제점이 많기 때문에 String으로 값을 넣을 수 있게 해야 함

    @BatchSize(size = 3) //최대 사이즈 3개로 한정
    @ToString.Exclude //ToString 추가 배제, 멤버는 게시글 데이터를 필요할 때만 조회하면 됨, 지연로딩
    @OneToMany(mappedBy = "member", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    //연관 관계의 주인을 명시해야 함, Many쪽에 외래키로 설정된 엔티티 입력
    //제약조건 CASCADE ON DELETE는 아님, orphanRemoval = true 자식 객체 삭제 옵션, CascadeType.PERSIST 꼭 있어야 함=같이 관리 상태가 되야하기 때문
    private List<BoardData> items; //관계 주인을 명시하지 않으면 매핑 안됨
}