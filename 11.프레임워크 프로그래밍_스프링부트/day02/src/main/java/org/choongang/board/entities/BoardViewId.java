package org.choongang.board.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode //동등성 비교, 중요! 없으면 기본키로 인식 못함
@AllArgsConstructor //값을 넣고 비교함, 기본 생성자 필요
@NoArgsConstructor
@Embeddable
public class BoardViewId { //복합키 정의

    private long seq;

    @Column(name="_uid")
    private int uid; //uid는 예약어이기 때문에 사용 불가->column(name)으로 변경
}
