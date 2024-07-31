package org.choongang.board.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestBoard {

    private Long seq;

    @NotBlank
    private String subject;

    @NotBlank
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
