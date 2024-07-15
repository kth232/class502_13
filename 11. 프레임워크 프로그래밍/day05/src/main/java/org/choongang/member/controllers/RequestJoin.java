package org.choongang.member.controllers;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestJoin {
    @NotBlank //(message = "이메일을 입력하세요") //공백 유무 검증, 검증 메세지 정의 가능
    @Email //(message = "이메일 형식이 아닙니다.") //validation 1순위 검증->validator 2순위 검증
    private String email;

    @NotBlank
    @Size(min=8) //최소 8자리
    private String password;

    @NotBlank
    @Size(min=8)
    private String confirmPassword;

    @NotBlank
    private String userName;

    @AssertTrue //참 유무 검증
    private boolean agree;

    /*
    private String email;
    private String password;
    private String confirmPassword;
    private String userName;
//    private String[] skill; //배열로 값 받아옴
//    private Set<String> skill;
//    private List<String> skill;
    private String skill; //,로 구분
    private boolean agree;
    
    private Address addr; //중첩 커맨드 객체: 변수명.항목명으로 매핑

     */
}
