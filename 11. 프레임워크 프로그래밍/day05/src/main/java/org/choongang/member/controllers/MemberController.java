package org.choongang.member.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.member.entities.Member;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

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

    @GetMapping("/login")
    public String login(@ModelAttribute RequestLogin form,
                        @CookieValue(name="savedEmail", required = false) String savedEmail //실제 쿠키 이름
                        /*, @SessionAttribute(name ="member", required = false) Member member*/) { //HttpSession session
        //애노테이션 잘 확인하기!
        // 쿠키 값 명시해야 지원 가능함
        // Member member = (Member)session.getAttribute("member");
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

        return "redirect:/";
    }

    @GetMapping("/list")
    public String list2(Model model) {
        /*
        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345678")
                .userName("<h1>user01")
                .regDt(LocalDateTime.now())
                .build();

        model.addAttribute("member", member);
        */

        //10명 유저 만들기(스트림<-편의성 좋음)
        List<Member> items = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Member.builder()
                        .email("user" + i + "@test.org")
                        .userName("user" + i)
                        .regDt(LocalDateTime.now())
                        .build())
                .toList();
        model.addAttribute("items", items); //정보 객체(스프링 기능과 연관), request가 아닌 session에 저장

        return "member/list";
    }

    /*
    @GetMapping("/list")
    public String list(@ModelAttribute MemberSearch search, Errors errors) { //에러 객체
        //요청 파라미터가 없더라도 search 객체에 null x
        //커맨드 객체 필드에 자동 바인딩->search 객체가 모델에 추가됨, 뷰에서 참조
        log.info(search.toString());

        boolean result = false;
        if(!result){
            throw new BadRequestException("예외 발생");
        }

        return "member/list";
    }
    */

    //경로 변수 연습
    @ResponseBody //반환값을 void로 만들기 위해 추가, rest로 응답하게 만든다
    @GetMapping({"/info/{id}/{id2}", "/info/{id}"}) //경로 변수 설정(복수개 가능), 바뀔 수 있는 값->변수 자료형에 따라 형변환해서 주입
    public void info(@PathVariable("id") String email, @PathVariable(name="id2", required = false) String email2) {
        //required=false를 통해 id2에 값이 없으면 null 값으로 대체되어 출력됨
        //과거엔 패턴과 변수명이 일치하면 알아서 인식하여 주입해줬는데 reflection api 업데이트로 변수명을 알 수 없게 되어 현재는 id값을 명시해줘야 인식 가능

        log.info("email:{}, email2:{}", email, email2);
        //url->http://localhost:3000/day05/member/info/email11/email22
        //결과->INFO o.c.m.c.MemberController - email:email11, email2:email22
    }

    @ResponseBody //일반 컨트롤러에서 rest로 응답하게 만들어줌
    @GetMapping("/list2")
    public List<Member> list() {
        List<Member> members = IntStream.rangeClosed(1, 10)
                .mapToObj(i-> Member.builder() //멤버 객체로 바꿔줌
                        .email("user" + i + "@test.org")
                        .password("12345678") //비번=가장 민감한 개인정보->JSON 변환 제외
                        .userName("user" + i)
                        .regDt(LocalDateTime.now())
                        .build())
                .toList();

        return members;
    }

    
//    @ExceptionHandler({Exception.class})
//    public String errorHandler(Exception e, HttpServletRequest request, HttpServletResponse response, Model model) { //에러 페이지는 초반에 세팅하는 것이 좋다
//        //정의한 예외만 동작함
//        //컨트롤러에 정의한 에러 처리가 컨트롤러 advice에 정의한 것보다 우선됨
//        e.printStackTrace();
//        log.info("MemberController에서 유입");
//
//        return "error/common"; //에러 발생 시 여기로 유입됨
//    }
    //컨트롤러에서 예외 페이지 출력 가능
    //예외마다 다른 페이지를 보여줘야 한다면 각각 정의하는 방법도 있음
    //일반적으로 예외 페이지는 1개만 만들어서 일관되게 만드는 것이 좋다->디자인이 바뀌는 일이 거의 없기 때문

    /*
    @ExceptionHandler({BadRequestException.class, RuntimeException.class})
    public String errorHandler(BadRequestException e, HttpServletRequest request, HttpServletResponse response, Model model) { //에러 페이지는 초반에 세팅하는 것이 좋다
        //정의한 예외만 동작함
        e.printStackTrace();
        return "member/common";
    }
    */

    /*
    @InitBinder //컨트롤러 내 공통적인 validator
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(joinValidator);
    }
     */
}
