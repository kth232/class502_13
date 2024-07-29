package org.choongang.board.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BoardView {

    @EmbeddedId //키 클래스를 기본키로 사용함 선언
    private BoardViewId id;
}