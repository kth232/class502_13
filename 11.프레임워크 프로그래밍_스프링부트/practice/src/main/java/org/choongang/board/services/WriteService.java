package org.choongang.board.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.board.controllers.RequestBoard;
import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WriteService {

    private final BoardDataRepository boardDataRepository;

    public void write(RequestBoard form) {
        BoardData boardData = new ModelMapper().map(form, BoardData.class);

        boardDataRepository.save(boardData);
        boardDataRepository.flush();
    }
}
