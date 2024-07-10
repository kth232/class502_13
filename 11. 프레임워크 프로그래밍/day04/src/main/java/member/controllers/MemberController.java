package member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //컨트롤러
public class MemberController {
    //스프링 컨테이너 안에 서블릿 기본 객체들을 어디서든 사용 가능하도록 편의상 처음부터 생성 및 초기화되어 담겨있음
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @GetMapping("member/join")
    public String join(@RequestParam(name = "name", defaultValue = "default") String name) { //@RequestParam 명시해야지만 찾아줌
        //requestParam: 요청 데이터 name 값 찾아서 주입, 없을 경우 null 값으로 대체
        //required = false는 기본값을 설정하면 자동으로 세팅됨
        System.out.println("name: "+ name);

        return "member/join";
    }

    @PostMapping("member/join")
    public String joinPs(RequestJoin form) {
        //매개변수에 무엇이든 주입 가능!

        System.out.println(form);
        return "member/join";
    }
}
