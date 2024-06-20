package org.choongang.global.exceptions;

import jakarta.servlet.http.HttpServletResponse;

public class CommonException extends RuntimeException{
    private int status;

    public CommonException(String message){
        this(message, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        //응답 코드 500(내부 서버 에러)=상수로 정의되어 있는 응답코드 사용
    }

    //message는 runtimeException이 기본으로 전달해주는 메세지
    public CommonException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
