package org.choongang.member.services;

import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.validators.Validator;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;

//회원가입 기능
public class JoinService {

    //확장-상속보단 구성, 개방폐쇄 원칙
    private Validator<RequestJoin> validator;
    private MemberMapper mapper;
    
    public JoinService(Validator<RequestJoin> validator, MemberMapper mapper) {
        this.validator = validator;
        this.mapper = mapper;
    }
    
    
    public void process(RequestJoin form) {
        //유효성 검사
        validator.check(form);

        //비밀번호 해시화-BCrypt, 12번 반복해서 암호화 비번 생성
        String hash = BCrypt.hashpw(form.getPassword(), BCrypt.gensalt(12));

        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setPassword(hash);
        member.setUserName(form.getUserName());

        int result = mapper.register(member);
        if (result < 1){
            throw new BadRequestException("회원가입에 실패하였습니다.");
        }
        /*
        String email = form.getEmail();
        if (email == null || email.isBlank()){
            throw new BadRequestException("enter your email");
        }
        */
    }
}
