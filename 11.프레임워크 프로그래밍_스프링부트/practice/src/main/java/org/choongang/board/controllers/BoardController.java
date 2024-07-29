package org.choongang.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.board.services.WriteService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final WriteService writeService;

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
    public String view(@ModelAttribute RequestBoard form) {
        System.out.println(form);
        return "front/board/view";
    }
}
