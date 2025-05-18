package org.choongang.global;

import lombok.Data;

@Data
public class CommonSearch {
    private long seq;
    private String sopt; // 검색 옵션
    private String skey; // 검색 키워드
    private int offset; //레코드 시작 위치
    private int limit; // 레코드 추출 개수
}
