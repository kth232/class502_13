package org.choongang.member.controllers;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class MemberSearch {
    @DateTimeFormat(pattern="yyyyMMdd") //변환할 날짜 형식 지정
    private LocalDate sDate; //검색 시작일

    @DateTimeFormat(pattern="yyyyMMdd") //변환할 날짜 형식 지정, 지정한 형식과 다른 형식으로 입력 시 에러 발생
    private LocalDate eDate; //검색 종료일
}
