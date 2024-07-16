package org.choongang.global.advices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.global.exceptions.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice("org.choongang")//해당 패키지 포함 하위 경로 모든 컨트롤러에 적용
@RequiredArgsConstructor
public class CommonControllerAdvice {
    /*
    private final MemberUtil memberUtil;

    @ModelAttribute("isLogin")
    public boolean isLogin() {
        System.out.println("유입");
        return memberUtil.isLogin();
    }


    @ModelAttribute("loggedMember")
    public Member loggedMember() {
        return memberUtil.getMember();
    }
    */

    @ExceptionHandler(Exception.class) //에러페이지 출력 위함
    public ModelAndView errorHandler(Exception e, HttpServletRequest request, HttpServletResponse response, Model model) {
        e.printStackTrace(); //exception -> 상태코드가 있든 없든 모두 예외 유입
        log.info("advice에서 유입");
        //컨트롤러에 정의한 에러 처리가 advice에 정의한 것보다 우선됨

        //기본 예외코드는 500으로 고정, 개발자가 정의한 예외는 400번대로 출력
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; //500

        if(e instanceof CommonException commonException) { //예외 출처 확인, 다형성(유연성)-> 안전한 캐스팅이 목적
            //CommonException commonException = (CommonException) e; //형변환->어짜피 할 것을 알기 때문에 생략 가능하게 바뀜
            status = commonException.getStatus();//응답코드 가져오기
        }

        //스프링이 제공하는 ModelAndView의 상태 코드 상세 설정 기능
        ModelAndView mv = new ModelAndView();

        mv.setViewName("error/common");
        mv.setStatus(status);

        return mv;

        //return "error/common"; //->string 타입일 경우
        //예외 페이지인데 상태 코드가 200(정상)이면 이상함->알맞는 상태 코드로 변경
    }
}
