package org.choongang.board.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.global.entities.BaseEntity;
import org.choongang.member.entities.Member;

@Data
@Builder
@Entity
@NoArgsConstructor //기본 생성자 오류 방지를 위해 public 범위로 추가
@AllArgsConstructor
public class BoardData extends BaseEntity { //Many쪽 테이블
    //자동으로 날짜, 시간 추가, 공통 속성화, 모든 테이블에 상속을 통해 추가됨

    @Id @GeneratedValue
    private Long seq;

    //지연로딩 설정->전역으로 지연로딩을 설정하는 것 권장함, FetchType.EAGER가 기본값이기 때문에 변경해줘야 함
    @ManyToOne(fetch=FetchType.LAZY) //다대일 관계 매핑, many쪽에 one으로 매핑할 엔티티 정의, left 조인함
    @JoinColumn(name="mSeq") //조인되는 컬럼의 이름을 변경할 때
    private Member member; //기본적으로 기본키에 정의된 속성으로 만들어짐->엔티티명_기본키 속성명(Member_seq)
    //변수명은 아무거나 써도 상관없음

    @Column(nullable = false)
    private String subject; //기본값: 255

    @Lob //clob으로 추가됨
    private String content;

//    @ManyToMany //manyToMany는 중간 테이블이 생성되기 때문에 외래키 생성 안됨
//    private List<HashTag> tags; //하나의 게시글에 여러 태그가 올 수 있기 때문에 list형
    //관계의 주인이 존재해야만 관계 매핑 가능
    //데이터의 중요도를 따졌을 때 게시글을 관계의 주인으로 만듦
}
