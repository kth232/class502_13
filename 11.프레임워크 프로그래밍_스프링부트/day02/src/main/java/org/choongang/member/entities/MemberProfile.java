package org.choongang.member.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@Builder
@Entity
@AllArgsConstructor @NoArgsConstructor
public class MemberProfile {

    @Id @GeneratedValue
    private Long seq;

    private String profileImage;
    private String status;

    @ToString.Exclude //ToString 추가 배제, 참조 꾾기->관계의 주인이 아닌 쪽의 연결을 끊어준다
    @OneToOne(mappedBy = "profile") //외래키 안만들어지고 참조함
    private Member member;
}
