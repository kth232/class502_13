package org.choongang.board.services;

import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.RequestBoard;
import org.choongang.board.entities.BoardData;
import org.choongang.board.exceptions.BoardNotFoundException;
import org.choongang.board.repositories.BoardDataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ModifyService {
    private final BoardDataRepository boardDataRepository;
    private final InfoService infoService;


    public void update(RequestBoard form) {
        BoardData data = boardDataRepository.findById(form.getSeq()).orElseThrow(BoardNotFoundException::new); //조회해야 영속성 상태가 됨
        System.out.println(data);

        data.setSubject(form.getSubject());
        data.setContent(form.getContent());
        data.setModifiedAt(LocalDateTime.now());

        boardDataRepository.saveAndFlush(data);
    }
}
