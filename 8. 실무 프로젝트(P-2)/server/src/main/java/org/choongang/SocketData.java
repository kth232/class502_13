package org.choongang;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocketData {
    private String from; //발신
    private String to; //수신
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //날짜 형식 변경
    private LocalDateTime regDt;
}
