package org.choongang.survey.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/survey")
@SessionAttributes("requestSurvey")
public class SurveyController {

    @ModelAttribute
    public RequestSurvey requestSurvey() {
        return new RequestSurvey();
    } //양식에서 값을 전달하는 것이 아니라 세션에 값 저장해서 전달
    //양식이 끝나면 제거됨, 임시로 유지하는 페이지

    @GetMapping("step1")
    public String step1() { //@ModelAttribute RequestSurvey form 매개변수로 넣을 필요 없어짐

        return "survey/step1";
    }

    @PostMapping("/step2")
    public String step2(RequestSurvey form, @SessionAttribute("requestSurvey") RequestSurvey form2) {

        log.info("form: " + form.toString());
        log.info("form2: " + form2.toString());
        //q1, q2번은 세션에서 유지, 세션 값을 커맨드 객체에 자동 주입됨

        return "survey/step2";
    }

    @PostMapping("/step3")
    public String step3(RequestSurvey form, @SessionAttribute("requestSurvey") RequestSurvey form2,
                        SessionStatus status, HttpServletRequest request) {

        log.info("form: " + form.toString());
        log.info("form2: " + form2.toString());
        //q1, q2번 답은 양식에서 전달x, 세션에 저장됨

        status.setComplete(); //세션 비우기->requestSurvey 세션 비우기 =매직 폼

        System.out.println("session 비우기 후: " + request.getSession().getAttribute("requestSurvey"));
        //null

        return "survey/step3";
    }
}
