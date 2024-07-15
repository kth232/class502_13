package org.choongang.member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Locale;

@Slf4j //자동 로거 연동
@Controller
@RequestMapping("/member2") //일반적으로 클래스명 위에 작성
@RequiredArgsConstructor
public class MemberController2 {
    //빈 객체는 싱글톤-> 기능적인 것처럼 한번만 만들어야 하는 객체에 사용

    private final MessageSource messageSource;
    private final HttpServletRequest request; //브라우저 언어정보 가져오기

    @ModelAttribute("commonValue") //컨트롤러 내에서 공통 데이터 유지할 때 사용, 이름 지정 필수
    public String commonValue() {
        return "common property value";
    }

    @ModelAttribute("skills")
    public List<String> skills() {
        return List.of("JAVA", "REACT", "JavaScript", "SPRING");
    }

    @ModelAttribute("skills2")
    public List<CodeValue> skills2() {
        return List.of(
                new CodeValue("자바", "JAVA"),
                new CodeValue("리액트", "REACT"),
                new CodeValue("자바스크립트", "JS"),
                new CodeValue("스프링", "SPRING")
        );
    }

    @GetMapping("/join") //요청이 들어올 때마다 생성되어야 하기 때문에 빈 객체로 관리하면 안됨
    public String join(@ModelAttribute RequestJoin form) {
        //Get일 때 커맨드 객체가 들어오지 않음, ->모델 주입, 필요에 따라 지정한 이름으로 대체 가능 @ModelAttribute("command")
        //RequestJoin form = new RequestJoin(); //비어있는 값이라도 명칭이 유지되도록 넣어줘야 매핑됨
        //model.addAttribute("requestJoin", form);

        Locale locale = request.getLocale(); //요청 헤더 Locale 정보에 따라 언어 다르게 적용, accept-Language
        String message = messageSource.getMessage("EMAIL", null, locale);
        log.info(message);

        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(RequestJoin form) {
        //RequestJoin form: 커맨드 객체, 검증 데이터->검증 실패 시 양식 출력, 클래스명이 변수명이 됨
        log.info(form.toString());
        return "member/join"; //뷰, 템플릿에서도 요청 데이터를 많이 이용함 ->EL식 속성으로 자동 추가
        //Post방식으로 값이 넘어와야만(EL식이 있을 때만) 가능->Get방식일 때도 커맨드 객체가 유지되게 해줘야 함
    }

    @GetMapping("/login")
    public String login(RequestLogin2 form) {
        if(form != null) {
            log.info("email: {}, PW: {}", form.email(), form.password()); //요청 데이터 매핑되어 값이 넘어오는지 확인
        }

        return "member/login";
    }

    /*

    @PostMapping("/join")
    public String joinPs(RequestJoin form) { //패턴만 입력해도 이동
        //return "redirect:/member/login"; //location: /day05/member/login
        // 앞에 '/'가 붙으면 절대 경로(주소 이동), 없으면 상대 경로(템플릿 경로)

        return "forward:/member/login"; //주소 이동 없이 버퍼만 치환
    }

    //lombok으로 가능
    //logger: log 연동, 레벨별 로그 메서드 존재
    //private final Logger log = LoggerFactory.getLogger(MemberController.class);

    @GetMapping("/join")
    public String join1() {
        log.info("no {}, {}", "mode1", "mode2"); //로그 문자, 순서대로 대체 가능
        return "member/join";
    }

    //어떤 요청 데이터든 사용 가능,
    // params: 요청 데이터 한정해서 매핑, mode가 join일 때만 유입되도록 한정
    @GetMapping(path="/join", params={"mode=join"}) //GET /member/join
    public String join() {
        log.info("mode=join");
        return "member/join"; //템플릿 경로 반환
    }

    //header: 요청 키로 헤더 정보에 포함되어 있어야만 유입됨
    //consumes = "application/json" -> 응답 헤더 content-type 설정
    // 직접 str으로 입력하는 것보다 정의되어 있는 상수(MediaType)를 사용하는 것이 오타 방지에 좋다.
    @PostMapping(path="/join", headers="appKey=1234", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public String joinPs(RequestJoin form) {

        log.info("joinPs run");
        return "redirect:/member/login"; //주소 이동(contextPath + /member/login)
    }
     */

    /*
    //@GetMapping("/member/join")
    @RequestMapping(path="/member/join", method = {RequestMethod.GET, RequestMethod.POST})
    //요청 메서드 여러 개 사용 가능
    public String join(Model model, HttpServletRequest request) {
        model.addAttribute("message", "HELLO");
        //model: view에서 사용하는 데이터, EL식으로 접근
        System.out.println("method: "+request.getMethod());

        return "member/join"; //해당 경로로 이동
    }
    */

    /*
    @GetMapping("/member/join")
    public ModelAndView join() {
        //model: view에서 사용하는 데이터, EL식으로 접근
        ModelAndView mav = new ModelAndView(); //어떤 값이 들어오든 동일하게 ModelAndView로 바꿔서 반환
        mav.addObject("message", "HELLO");
        mav.setViewName("member/join"); //view: 테플릿 경로

        return mav; //하지만 잘 사용하지 않는 방법..
    }
    */
}
