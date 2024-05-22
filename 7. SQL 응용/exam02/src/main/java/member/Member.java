package member;

import lombok.*;

import java.time.LocalDateTime;

@Data //= @Getter @Setter @ToString @EqualsAndHashCode
@AllArgsConstructor //초기화 생성자 ->기본 생성자 없어서 오류 발생-> 기본 생성자 추가
//@NoArgsConstructor(access =AccessLevel.PRIVATE) //기본 생성자, 접근 제어자 설정
@NoArgsConstructor
@RequiredArgsConstructor
public class Member {
    @NonNull //생성자 매개변수, 초기화
    private String userId;
    @NonNull
    private String userNm;
    private String email;
    @ToString.Exclude //toString 출력 배제
    private LocalDateTime regDt; //회원가입일
}

