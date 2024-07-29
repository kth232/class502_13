package org.choongang.board.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.board.controllers.RequestBoard;
import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
import org.choongang.member.controllers.RequestJoin;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDataRepository boardDataRepository;

    public void save(RequestBoard form) {
        BoardData boardData = new ModelMapper().map(form, BoardData.class);

        save(boardData);
    }

    public void save(BoardData boardData) {

        boardDataRepository.save(boardData);
        boardDataRepository.flush();
    }
}
