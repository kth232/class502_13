package org.choongang.member.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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

    @JsonIgnore //JSON 변환 시 제외됨
    private String password; //비번은 민감한 개인정보->JSON 변환 제외

    private String userName;

    //entity마다 입력해줘야 하는 번거로움 -> 설정 클래스에 형식 한정
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //JSON 날짜 형식 변환
    private LocalDateTime regDt;
}
