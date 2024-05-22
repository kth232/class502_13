package member;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor // 상수 형태로 정의
public class Board {
    private int seq;
    private final String subject; //final 예약어 사용 시 초기화 안하면 오류 발생
    private final String content;
    private String poster;
}
