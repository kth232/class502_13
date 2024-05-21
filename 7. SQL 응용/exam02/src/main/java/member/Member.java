package member;

import lombok.*;

import java.time.LocalDateTime;

@Data //= @Getter @Setter @ToString @EqualsAndHashCode
@AllArgsConstructor //초기화 생성자 ->기본 생성자 없어서 오류 발생-> 기본 생성자 추가
@NoArgsConstructor(access =AccessLevel.PUBLIC) //기본 생성자, 접근 제어자 설정
public class Member {
    private String userId;
    private String userNm;
    private String email;
    private LocalDateTime regDt; //회원가입일
}

