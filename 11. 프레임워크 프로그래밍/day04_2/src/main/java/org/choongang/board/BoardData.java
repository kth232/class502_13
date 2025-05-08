package org.choongang.board;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BoardData {
    private long seq;
    private String poster;
    private String subject;
    private String content;
    private LocalDateTime createdAt;
}
