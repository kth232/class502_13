package org.choongang.global.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Getter @Setter //자동 추가할 수 있게 함
public class CommonException extends RuntimeException{ //공통 예외

    private HttpStatus status; //응답코드 상수 정의됨

    private Map<String, List<String>> errorMessages; //에러 메세지

    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR); //500
    }

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

//    public HttpStatus getStatus() {
//        return status;
//    }
}
