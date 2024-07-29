package org.choongang.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    @GetMapping("/write")
    public String write(@ModelAttribute RequestBoard form) {
        return "front/board/write";
    }

    @PostMapping("/write")
    public String writePs(@Valid RequestBoard form, Errors errors) {

        if (errors.hasErrors()) {
            return "front/board/write";
        }

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String list(@ModelAttribute RequestBoard form) {
        log.info(String.valueOf(form));
        return "front/board/list";
    }
}
