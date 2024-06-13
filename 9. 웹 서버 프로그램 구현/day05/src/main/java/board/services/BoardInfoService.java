package board.services;

import board.entities.BoardData;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

public class BoardInfoService {
    public List<BoardData> getList() {
        //게시글 목록 조회 로직
        List<BoardData> items = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> BoardData.builder()
                        .seq(i)
                        .subject("title" +i)
                        .content("content"+i)
                        .poster("poster"+i)
                        .regDt(LocalDateTime.now())
                        .build())
                .toList();
        return items;
    }
}
