package member;

import lombok.*;

import java.time.LocalDateTime;

@Builder //lombok을 사용한 빌더
@ToString
//@NoArgsConstructor(access = AccessLevel.PUBLIC)
// 기본 생성자를 꼭 써야 하는 경우 @NoArgsConstructor @AllArgsConstructor 사용
@NoArgsConstructor @AllArgsConstructor
public class User2 {
    private String userId;
    private String userNm;
    private String email;
    private LocalDateTime regDt;
}
