package member;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder //기본 생성자 필요
public class Member {
    private long userNo; //DB 필드와 명칭이 동일해야 함
    private String userId;
    private String userPw;
    private String userNm;
    private String mobile;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
