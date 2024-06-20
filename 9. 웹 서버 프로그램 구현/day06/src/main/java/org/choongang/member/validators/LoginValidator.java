package org.choongang.member.validators;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;

public class LoginValidator implements Validator<HttpServletRequest>, RequiredValidator {
    private MemberMapper mapper;

    public LoginValidator(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void check(HttpServletRequest form) {
        String email = form.getParameter("email");
        String password = form.getParameter("password");

        //필수 항목 검증
        checkRequired(email, new BadRequestException("이메일을 입력하세요"));
        checkRequired(password, new BadRequestException("비밀번호를 입력하세요"));

        //이메일로 회원이 조회되는지 검증
        //아이디, 비번 중 어떤 게 틀렸는지 모르게 하는 게 보안성이 높다(예측 불가능성)
        String message = "이메일 또는 비밀번호가 일치하지 않습니다";
        Member member = mapper.get(email);
        checkTrue(member != null, new BadRequestException(message));

        //비밀번호 일치 여부 체크
        boolean isMatched = BCrypt.checkpw(password, member.getPassword()); //사용자 입력값과 DB에 저장된 비번 일치 여부 확인
        //비번은 해시화됨(유동 해시) -> 별도의 검증 메서드로 확인
        checkTrue(isMatched, new BadRequestException(message));
    }
}
