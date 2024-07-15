package org.choongang.member.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller //컨트롤러로 동작하는 클래스
@RequestMapping("/member") //공통으로 매핑할 주소 설정
@RequiredArgsConstructor //의존성 주입-생성자 매개변수
public class MemberController {

    private final JoinValidator joinValidator;
    private final JoinService joinService;

    private final LoginService loginService;
    private final LoginValidator loginValidator;

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form) { //모델
        
        return "member/join";
    }
    
    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors) { //커맨드 객체 유입, post로 넘어온 값을 검증할 것
        //회원가입 데이터 검증
        //@Valid 애노테이션으로 검증할 데이터라는 것을 알려줘야 함
        //반드시 커맨드 객체 바로 뒤에 errors 객체가 뒤따라야 정상 동작함, 중간에 다른 게 추가되면 동작x
        //검증 실패 시 errors 객체에 넘어감
        joinValidator.validate(form, errors); //전역 validator를 설정하면 여기서 따로 설정할 필요 x

        if(errors.hasErrors()) { //reject, rejectValue가 한번이라도 호츌되면 true가 됨
            return "member/join"; //검증실패 시 다시 회원가입 화면을 보여줌
        }
        joinService.process(form); //회원가입 처리
        
        return "redirect:/member/login"; //location header를 통해 주소 이동
    }
    
    /*
    @InitBinder //컨트롤러 내 공통적인 validator
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(joinValidator);
    }
     */

    @GetMapping("/login")
    public String login(@ModelAttribute RequestLogin form,
                        @CookieValue(name="savedEmail", required = false) String savedEmail
                        /*@SessionAttribute(name ="member", required = false) Member member*/) { //HttpSession session
        //Member member = (Member)session.getAttribute("member");
        /*
        if(member != null) { //NullPointerException 방지
            log.info(member.toString());
        }
        */

        if(savedEmail != null) {
            form.setSaveEmail(true);
            form.setEmail(savedEmail);
        }

        return "member/login";
    }
    
    @PostMapping("/login")
    public String loginPs(@Valid RequestLogin form, Errors errors) { //커맨드 객체 검증
        loginValidator.validate(form, errors);

        if(errors.hasErrors()) { //reject, rejectValue가 한번이라도 호츌되면 true가 됨
            return "member/login"; //검증 실패 시 다시 로그인 화면을 보여줌
        }
        //로그인 처리
        loginService.process(form);
        
        return "redirect:/"; //검증 완료 후 메인화면으로 이동
    }

    @RequestMapping("/logout") //get, post 상관없이
    public String logout(HttpSession session) {
        session.invalidate(); //세션 비우기

        return "redirect: /member/login";
    }
}
