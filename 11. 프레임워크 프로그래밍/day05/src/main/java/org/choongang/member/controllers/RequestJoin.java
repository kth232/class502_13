package org.choongang.member.controllers;

import lombok.Data;

import java.util.List;

@Data
public class RequestJoin {
    private String email;
    private String password;
    private String confirmPassword;
    private String userName;
//    private String[] skill; //배열로 값 받아옴
//    private Set<String> skill;
    private List<String> skill;
//    private String skill; //,로 구분
    private boolean agree;
    
    private Address addr; //중첩 커맨드 객체: 변수명.항목명으로 매핑
}
