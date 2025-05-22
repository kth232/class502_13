package org.choongang.member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

    @GetMapping("/member/signup")
    public String join(@RequestParam("email") String email, @RequestParam("agree") boolean agree, Model model) {
        // HandlerAdapter에 의해 알아서 자료형도 바뀐다
        System.out.printf("email=%s, agree=%s%n", email, agree);
        model.addAttribute("message", "hello");

        //http://localhost:8080/day06_1/member/signup?email=test@test.com&agree=true

        return "member/join"; // /WEB-INF/templates/member/join.jsp 뷰 경로
    }

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
