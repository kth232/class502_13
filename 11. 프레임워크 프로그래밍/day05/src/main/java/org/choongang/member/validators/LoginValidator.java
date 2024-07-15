package org.choongang.member.validators;


import lombok.RequiredArgsConstructor;
import org.choongang.member.controllers.RequestLogin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor //DI-생성자 매개변수
public class LoginValidator implements Validator { //validator를 정의해야 하는 경우 구현

    private final MemberMapper mapper;

    @Override
    public boolean supports(Class<?> clazz) { // RequestJoin 커맨드 객체만 검증하도록 제한

        return clazz.isAssignableFrom(RequestLogin.class); //검증하고자 하는 커맨드 객체 한정함
    }

    @Override
    public void validate(Object target, Errors errors) { //실제 검증 수행하는 부분

        if(errors.hasErrors()){ //Bean validation 검증 실패 시 다음 검증을 진행 x
            return; //앞에서 검증 실패하면 다음 검증 진행 안해도 됨, null 방지
        }
        /**
         *  email로 회원이 조회되는지 검증
         *  조회된 회원의 비밀번호가 입력한 값과 일치하는지 검증(BCrypt 검증)
         */

        //validation에서 검증 가능한 부분
        RequestLogin form = (RequestLogin) target;
        String email = form.getEmail();
        String password = form.getPassword(); //커맨드 객체는 사용자가 입력한 값이 들어있다

        if(StringUtils.hasText(email)) {
            Member member = mapper.get(email);
            if(member == null) {
                //errors.rejectValue("email", "Check.emailPassword");
                errors.reject("Check.emailPassword");
            }
            if (member != null && StringUtils.hasText(password) && !BCrypt.checkpw(password, member.getPassword())) {
                //해시회된 비번과 사용자 입력 비번의 일치 유무 확인
                //errors.rejectValue("password", "Check.emailPassword");
                errors.reject("Check.emailPassword");
            }
        }
    }
}
