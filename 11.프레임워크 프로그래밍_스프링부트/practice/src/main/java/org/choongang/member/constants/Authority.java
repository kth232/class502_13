package org.choongang.member.constants;

public enum Authority {//테이블로 자동 변환
    USER,
    MANAGER, //ordinal로 변환하면 코드 추가 또는 수정 시 순서 바뀜
    ADMIN
}