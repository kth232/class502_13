package org.choongang.board.exceptions;

public class BoardNotFoundException extends RuntimeException {
    public BoardNotFoundException() {
        super("게시글을 찾을 수 없습니다");
        //게시글 없는 상태에서 조회 시 예외 처리
        //응답코드까지 추가하면 좋음->404
    }
}
