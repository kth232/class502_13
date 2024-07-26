package org.choongang.board.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor
public class HashTag {
    @Id
    private String tag;

//    @ToString.Exclude //태그의 게시글 배제
//    @ManyToMany(mappedBy = "tags")
//    private List<BoardData> items;
}
