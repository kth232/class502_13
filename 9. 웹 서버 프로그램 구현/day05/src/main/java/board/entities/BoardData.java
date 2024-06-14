package board.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder //내부에서 객체를 빌드해서 만듦-> 직접 객체 생성(new 연산자) x ->private 생성자(통제)
@NoArgsConstructor
@AllArgsConstructor //기본 생성자를 사용할 때 추가
public class BoardData {
    private long seq;
    private String subject;
    private String content;
    private String poster;
    private LocalDateTime regDt;
}
