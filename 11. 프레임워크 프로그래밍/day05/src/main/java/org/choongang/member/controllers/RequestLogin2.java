package org.choongang.member.controllers;

import lombok.Builder;

//레코드 클래스=데이터 클래스
//상수로 저장되기 때문에 값 변경 불가(setter, getter 불가->@Data 불가)
@Builder
public record RequestLogin2(
        String email, //생성자 매개변수 위치에 자료형 명시
        String password
) {
}
