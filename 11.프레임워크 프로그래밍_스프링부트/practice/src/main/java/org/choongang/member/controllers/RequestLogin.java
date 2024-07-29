package org.choongang.member.controllers;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestLogin { //로그인 커맨드 객체
    @NotBlank @Email
    private String email;

    @NotBlank
    private String password;
}