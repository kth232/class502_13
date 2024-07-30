package org.choongang.board.services;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.RequestBoard;
import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteService {
    private final BoardDataRepository boardDataRepository;
    private final InfoService infoService;

    /**
     * 게시글 삭제
     */
    public void delete(Long seq) {
        BoardData data = infoService.get(seq); //조회해야 영속성 상태가 됨
        System.out.println(data);

        boardDataRepository.delete(data);
        boardDataRepository.flush();
    }
}
