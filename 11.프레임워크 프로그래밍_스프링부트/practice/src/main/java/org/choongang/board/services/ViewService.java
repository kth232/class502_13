package org.choongang.board.services;

import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.RequestBoard;
import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewService {

    private BoardDataRepository boardDataRepository;
    private RequestBoard requestBoard;

    public void view(@ModelAttribute RequestBoard form, Model model) {
        List<BoardData> list = boardDataRepository.findAll();
        model.addAttribute("boardData", list);
    }
}
