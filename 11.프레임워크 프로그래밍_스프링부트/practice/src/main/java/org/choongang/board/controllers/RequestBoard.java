package org.choongang.board.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestBoard {

    @NotBlank
    private String subject;

    @NotBlank
    private String content;
}
