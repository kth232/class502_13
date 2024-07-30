package org.choongang.board.services;

import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.RequestBoard;
import org.choongang.board.entities.BoardData;
import org.choongang.board.exceptions.BoardNotFoundException;
import org.choongang.board.repositories.BoardDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewService {

    private final BoardDataRepository boardDataRepository;
    private BoardData boardData;

    public void view(@ModelAttribute RequestBoard form, Model model) {
        //boardData data = boardData.getData();

        List<BoardData> list = boardDataRepository.findAll();
        model.addAttribute("boardData", list);
    }

    public BoardData get(Long seq) {
        BoardData board = boardDataRepository.findById(seq).orElseThrow(BoardNotFoundException::new);
        //2차 데이터 가공 처리

        return board;
    }

    public RequestBoard getForm(Long seq) {
        BoardData data = boardDataRepository.findById(seq).orElseThrow(BoardNotFoundException::new);
        RequestBoard form = new ModelMapper().map(data, RequestBoard.class);
        //2차 처리, 커맨드객체로 변경해줘야 검증 수행

        return form;
    }
}
