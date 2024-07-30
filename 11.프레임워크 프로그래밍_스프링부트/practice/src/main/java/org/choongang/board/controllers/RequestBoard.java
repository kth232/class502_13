package org.choongang.board.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestBoard {

    private Long seq;

    @NotBlank
    private String subject;

    @NotBlank
    private String content;
}
