package org.choongang.member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member") //공통 주소 처리 /member/join도 가능
public class MemberController {

    @GetMapping("/join") //요청주소 /member/join
//    @GetMapping // 공통 주소가 @RequestMapping("/member/join")일 경우
//    @RequestMapping(path="/member/join" method=RequestMapping)
    public String join() {
        System.out.println("join() 유입");
        return "member/join";
    }

//    @PostMapping // 공통 주소가 @RequestMapping("/member/join")일 경우
    @PostMapping("/join") // /member/join
    public String joinPs(RequestJoin form) {
        //RequestParam은 하나씩만 매칭됨->커맨드 객체 RequestJoin 사용
        System.out.println(form);
        return "member/join";
    }

//    @GetMapping("/member/signup")
//    public String join(@RequestParam(name="email", defaultValue = "noEmail" /*required=false*/) String email,
//                       @RequestParam(name = "agree", required=false) boolean agree, Model model) {
//        // HandlerAdapter에 의해 알아서 자료형도 바뀐다
//        System.out.printf("email=%s, agree=%s%n", email, agree);
//        model.addAttribute("message", "hello");
//
//        //http://localhost:8080/day06_1/member/signup?email=test@test.com&agree=true
//        //http://localhost:8080/day06_1/member/signup
//
//        return "member/join"; // /WEB-INF/templates/member/join.jsp 뷰 경로
//    }

    // 동일하게 처리됨
//    @GetMapping("member/signup")
//    public ModelAndView join() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("member/join"); //뷰(템플릿) 경로
//        mav.addObject("message", "hello"); //속성 추가
//
//        return mav;
//    }
}
