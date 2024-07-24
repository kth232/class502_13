package org.choongang.board.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
//@IdClass(BoardViewId.class) //복합키 클래스
public class BoardView {

    @EmbeddedId
    private BoardViewId id;

    /*
    @Id @GeneratedValue
    private long seq;

    @Id
    @Column(name="_uid")
    private int uid; //uid는 예약어이기 때문에 사용 불가->column(name)으로 변경, 작은 따옴표를 붙이는 방법도 있음
    */
}