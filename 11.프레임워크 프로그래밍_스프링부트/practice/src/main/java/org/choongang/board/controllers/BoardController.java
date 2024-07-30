package org.choongang.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
import org.choongang.board.services.ViewService;
import org.choongang.board.services.WriteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller //컨트롤러는 컨트롤러의 역할만
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final WriteService writeService;
    private final ViewService viewService;
    private final BoardDataRepository boardDataRepository;

    @GetMapping("/write")
    public String write(@ModelAttribute RequestBoard form) {
        return "front/board/write";
    }

    @PostMapping("/write")
    public String writePs(@Valid RequestBoard form, Errors errors) {

        if (errors.hasErrors()) {
            return "front/board/write";
        }

        writeService.write(form);
        System.out.println(form);

        return "redirect:/board/view";
    }

    @GetMapping("/view")
    public String view(@ModelAttribute RequestBoard form, Model model) {
        viewService.view(form, model);

        System.out.println(form);
        return "front/board/view";
    }
}
