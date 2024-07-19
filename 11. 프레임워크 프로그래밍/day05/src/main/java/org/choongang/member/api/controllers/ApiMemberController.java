package org.choongang.member.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.global.Utils;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.rests.JSONData;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.services.JoinService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
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
    private final Utils utils;

    @PostMapping //POST /api/member
    public ResponseEntity join(@RequestBody @Valid RequestJoin form, Errors errors) { //@RequestBody 추가해야 json형식으로 데이터 변환
        //커맨드 객체(=사용자 입력값)에 대한 검증 처리, rest 형식으로 개발할 때는 직접 정의해야 함
        //Error는 필드 에러, 글로벌 에러 정보 확인하는 메서드 가짐
        //초반에 세팅하는 부분
        if(errors.hasErrors()){ //errors 객체에 있는 정보 가공
            //원래는 에러 코드(application.properties) 반환
            //공통 error 메세지 유틸 사용, 에러 코드에 맞는 메세지 출력
            throw new BadRequestException(utils.getErrorMessages(errors));
            /*
            errors.getFieldErrors().forEach(System.out::println);
            errors.getGlobalErrors().forEach(System.out::println);

            return ResponseEntity.badRequest().build();
             */
        }

        /*
        boolean result = false;
        if(!result) {
            throw new BadRequestException("예외 테스트"); //에러도 JSON 형식으로 통일성 있게 응답하는 것이 좋다.
        }
        */
        joinService.process(form); //회원가입 서비스 추가

        //응답 코드가 201, 출력 바디 데이터x
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /*
    @GetMapping("/info3/{email}") //경로 변수
    public Member info3(@PathVariable("email") String email) { //반환값이 자바 객체
        //Content-type: application/json
        //json formatter(확장 프로그램)를 사용해서 형식에 맞게 출력
        Member member = mapper.get(email); 

        return member;
    }

    @GetMapping("/info2/{email}") //경로 변수
    public ResponseEntity info2(@PathVariable("email") String email) { //반환값이 responseEntity
        //Content-type: application/json
        //json formatter(확장 프로그램)를 사용해서 형식에 맞게 출력
        Member member = mapper.get(email);

        return ResponseEntity.ok(member); //응답코드 반환
    }
    */

    @GetMapping("/info/{email}") //경로 변수
    public JSONData info(@PathVariable("email") String email) { //반환값이 JSONData
        //Content-type: application/json
        //json formatter(확장 프로그램)를 사용해서 형식에 맞게 출력
        Member member = mapper.get(email);
        //성공해서 응답코드가 200일 때는 responseEntity 사용 안해도 됨
        //형식을 통일해서 응답

        return new JSONData(member);
    }

    @GetMapping("/list")
    public ResponseEntity<JSONData> list() { //<List<Member>>
        List<Member> members = IntStream.rangeClosed(1, 10)
                .mapToObj(i->Member.builder() //멤버 객체로 바꿔줌
                        .email("user" + i + "@test.org")
                        .password("12345678") //비번=가장 민감한 개인정보->JSON 변환 제외
                        .userName("user" + i)
                        .regDt(LocalDateTime.now())
                        .build())
                .toList();

        HttpHeaders headers  = new HttpHeaders(); //헤더
        headers.add("t1", "v1");
        headers.add("t2", "v2");

        return new ResponseEntity<>(new JSONData(members), headers, HttpStatus.OK); //바디 데이터, 헤더, 상태코드 201
    }

    @GetMapping(path="/test", produces= "text/html;charset=UTF-8") //응답 헤더에 content-type 설정
    public String test() {
        //content-type: text/plain

        return "안녕!"; //produce 설정하면 한글 깨지지 않음
    }

    @GetMapping("/test2")
    public void test2() { //RestController는 void형 가능->내부적으로 처리
        log.info("test2.."); // 응답 바디 없음
    }

    /*
    @ExceptionHandler(Exception.class) //가장 상위 클래스로 정의해서 모든 예외가 유입되도록 함
    public ResponseEntity<JSONData> errorHandler(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; //500
        //개발자가 정의한 예외이면 가져와서 해당 응답코드로 처리
        if(e instanceof CommonException commonException){
            status= commonException.getStatus();
        }
        JSONData data = new JSONData();
        data.setSuccess(false);
        data.setMessage(e.getMessage());
        data.setStatus(status);

        e.printStackTrace();
        return ResponseEntity.status(status).body(data);
    }
    */
}
