package org.choongang.member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.member.entities.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/join")
    public String join() {

        return "member/join"; //템플릿 경로
    }

    @PostMapping("/join.jsp")
    public String joinPs(RequestJoin form) {

        return "redirect:/member/login"; //주소 이동
    }

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
