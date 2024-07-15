package org.choongang.member.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestLogin { //사용자가 입력한 값 전달

    @NotBlank
    private String email;

    @NotBlank
    private String password;
    private boolean saveEmail;
}
