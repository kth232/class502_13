package org.choongang.member.entities;

import jakarta.persistence.*; //entity, table등을 지원하는 패키지명 주의,
import lombok.*;
import org.choongang.board.entities.BoardData;
import org.choongang.global.entities.BaseEntity;
import org.choongang.member.constants.Authority;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor //기본 생성자 없으면 접근 불가?
@Builder
@Data
@Entity //JPA가 관리하는 데이터, 해당 데이터를 바탕으로 테이블이 만들어짐, 데이터 한 행을 의미
//@Table(name="CH_MEMBER") //name 값으로 지정한 이름의 테이블이 없으면 새로 생성, 있으면 기존 테이블로 매핑
/*
@Table(indexes= { //테이블 이름이 클래스명과 다른 경우 직접 설정해야 함, 제약 조건 조합 시 사용
    @Index(name="idx_created_at_desc", columnList = "createdAt DESC"), //DB가 아닌 클래스에 있는 속성으로 해야 함
    @Index(name="uq_email_passsword", columnList = "email, password", unique = true) //유니크 테이터
})*/
public class Member extends BaseEntity { //기본 엔티티명, 테이블명은 클래스명, 정의된 내용으로 테이블 생성, baseEntity 상속
    //엔티티 상세하게 설정할 수 있는 애노테이션 제공

    @Id @GeneratedValue//@Id=기본키 설정(필수) @GeneratedValue(strategy = GenerationType.AUTO)=기본값, 자동 증감 번호
    private Long seq;
    
    @Column(length=60, unique=true, nullable = false) //유니크 제약조건, not null 제약조건 추가(nullable: 필수 항목 지정)
    private String email;

    @Column(length=65, nullable = false) //필수 항목 설정
    private String password;

    @Column(name="name" , nullable = false, length=40) //테이블 컬럼명 지정
    private String userName; //엔티티명은 userName

    //@Lob //->Clob 형태로 만들어짐
    @Transient //매핑 무시->DB 반영이 아니라 내부적으로 사용(데이터 2차 가공 등)할 목적일 때
    private String introduction;

    @Column(length=10) //문자열 길이 설정
    @Enumerated(EnumType.STRING) //테이블 컬럼으로 들어옴, 상수로 정의했는데 number형으로 들어옴->기본값이 ordinal->상수 번호로 출력
    private Authority authority; //ordinal로 들어오면 문제점이 많기 때문에 String으로 값을 넣을 수 있게 해야 함

    @BatchSize(size=3) //최대 사이즈 3개로 한정
    @ToString.Exclude //ToString 추가 배제, 멤버는 게시글 데이터를 필요할 때만 조회하면 됨, 지연로딩
    @OneToMany(mappedBy = "member", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true) 
    //연관 관계의 주인을 명시해야 함, Many쪽에 외래키로 설정된 엔티티 입력
    //제약조건 CASCADE ON DELETE는 아님, orphanRemoval = true 자식 객체 삭제 옵션, CascadeType.PERSIST 꼭 있어야 함=같이 관리 상태가 되야하기 때문
    private List<BoardData> items; //관계 주인을 명시하지 않으면 매핑 안됨

    @OneToOne(fetch = FetchType.LAZY) //프로필 정보가 필요할 때만 조인해서 데이터 가져옴
    @JoinColumn(name="profile_seq") //unique 제약조건 자동으로 걸림, 중복 프로필을 가질 수 없기 때문
    private MemberProfile profile; //일대일 연관관계(회원-프로필), 회원이 관계의 주인

    /*
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp //내부적으로 데이터 들어감?
    private LocalDateTime modifiedAt;
    //공통 속성화로 만드는 게 공유하기 좋다->상속
    */

    /*
    @Temporal(TemporalType.DATE) //날짜, 시간, 날짜+시간을 가져올 때 사용->분리해서 사용하는 경우는 거의 없다.
    private Date date; //자바 time 패키지는 자료형으로 이미 체계적으로 구분됨(localDate, localTime, localDateTime)
    // ->굳이 temporal을 사용할 필요가 없다..
    */
}
