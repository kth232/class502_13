package org.choongang.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.choongang.board.repositories.BoardDataRepository;
import org.choongang.board.services.DeleteService;
import org.choongang.board.services.InfoService;
import org.choongang.board.services.WriteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller //컨트롤러는 컨트롤러의 역할만
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final WriteService writeService;
    private final InfoService infoService;
    private final DeleteService deleteService;


    @GetMapping("/write")
    public String write(@ModelAttribute RequestBoard form) {
        return "front/board/write";
    }

    @PostMapping("/write")
    public String writePs(@Valid RequestBoard form, Errors errors) {
        //String mode = form.getSeq() == null ? "update" : "write"; //게시글 번호가 있으면 수정, 없으면 작성

        if (errors.hasErrors()) {
            return "front/board/write";
            //return "front/board" + mode;
        }

        writeService.write(form);
        System.out.println(form);

        return "redirect:/board/view";
    }

    @GetMapping("/view")
    public String view(@ModelAttribute RequestBoard form, Model model) {
        infoService.view(form, model);

        System.out.println(form);

        return "front/board/view";
    }

    @GetMapping("/delete/{seq}")
    public String delete(@PathVariable("seq") Long seq) {

        deleteService.delete(seq);

        return "front/board/view";
    }


    @GetMapping("/update/{seq}")
    public String update(@PathVariable("seq") Long seq, Model model) {
        RequestBoard form = infoService.getForm(seq);
        model.addAttribute("requestBoard", form);

        return "front/board/view";
    }
}
