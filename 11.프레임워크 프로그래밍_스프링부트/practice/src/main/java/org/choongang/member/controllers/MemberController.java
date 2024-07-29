package org.choongang.member.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final JoinValidator joinValidator;
    private final JoinService joinService;

    private final LoginValidator loginValidator;
    private final LoginService loginService;

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form) {
        return "front/member/join";
    }

    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors) {

        joinValidator.validate(form, errors);

        if (errors.hasErrors()) {
            return "front/member/join";
        }

        joinService.save(form);

        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute RequestLogin form) {

        return "front/member/login";
    }

    @PostMapping("/login")
    public String loginPs(@Valid RequestLogin form, Errors errors) {

        loginValidator.validate(form, errors);

        if (errors.hasErrors()) {
            return "front/member/login";
        }
        loginService.showInfo(form);
        System.out.println(form);

        return "redirect:/board/list";
    }
}
