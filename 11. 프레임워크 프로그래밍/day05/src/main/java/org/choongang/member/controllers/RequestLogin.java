package org.choongang.member.controllers;

import lombok.Data;

@Data
public class RequestLogin { //사용자가 입력한 값 전달
    private String email;
    private String password;
    private boolean saveEmail;
}
