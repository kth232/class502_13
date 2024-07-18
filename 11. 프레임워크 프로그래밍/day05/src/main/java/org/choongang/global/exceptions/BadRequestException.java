package org.choongang.global.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

public class BadRequestException extends CommonException{
    public BadRequestException(String message) { //스트링 형태일 때 넣어줌
        super(message, HttpStatus.BAD_REQUEST); //400번대로 고정
    }
    
    //Map형태를 매개변수로 받는 생성자 추가
    public BadRequestException(Map<String, List<String>> errorMessages) { 
        super(null, HttpStatus.BAD_REQUEST);
        setErrorMessages(errorMessages);
    }
}
