package org.choongang.global.exceptions;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException{ //공통 예외

    private HttpStatus status; //응답코드 상수 정의됨

    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR); //500
    }

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
