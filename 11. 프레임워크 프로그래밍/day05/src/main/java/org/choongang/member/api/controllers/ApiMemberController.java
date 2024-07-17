package org.choongang.member.api.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.services.JoinService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class ApiMemberController {
    //사실 서비스로 개발하는 것이 좋지만 json 연습용으로 컨트롤러 구현
    private final MemberMapper mapper;
    private final JoinService joinService;

    @PostMapping("") //POST /api/member
    public void join(RequestJoin form) {
        log.info(form.toString());
    }

    @GetMapping("/info/{email}") //경로 변수
    public Member info(@PathVariable("email") String email) { //반환값이 자바 객체
        //Content-type: application/json
        //json formatter(확장 프로그램)를 사용해서 형식에 맞게 출력
        Member member = mapper.get(email); 

        return member;
    }

    @GetMapping("/list")
    public List<Member> list() {
        List<Member> members = IntStream.rangeClosed(1, 10)
                .mapToObj(i->Member.builder() //멤버 객체로 바꿔줌
                        .email("user" + i + "@test.org")
                        .password("12345678") //비번=가장 민감한 개인정보->JSON 변환 제외
                        .userName("user" + i)
                        .regDt(LocalDateTime.now())
                        .build())
                .toList();

        return members;
    }

    @GetMapping(path="/test", produces= "text/html;charset=UTF-8") //응답 헤더에 content-type 설정
    public String test() {
        //content-type: text/plain

        return "안녕!";
    }

    @GetMapping("/test2")
    public void test2() { //RestController는 void형 가능->내부적으로 처리
        log.info("test2.."); // 응답 바디 없음
    }
}
