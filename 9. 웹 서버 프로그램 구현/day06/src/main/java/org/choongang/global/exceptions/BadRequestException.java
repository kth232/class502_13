package org.choongang.global.exceptions;

import jakarta.servlet.http.HttpServletResponse;

public class BadRequestException extends CommonException{
    public BadRequestException() {
        this("BAD REQUEST!");
    };

    public BadRequestException(String message){
        super(message, HttpServletResponse.SC_BAD_REQUEST);
        //응답 코드 400(요청 실패)
    }
}
