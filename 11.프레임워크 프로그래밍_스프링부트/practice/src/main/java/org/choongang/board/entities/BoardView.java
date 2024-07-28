package org.choongang.board.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BoardView {

    @EmbeddedId
    private BoardViewId id;
}