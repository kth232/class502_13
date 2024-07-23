package org.choongang.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/join")
    public String join() {
        log.info("modify code");
        return "member/join";
    }

    @GetMapping("login")
    public String login() {

        return "member/login";
    }

}
