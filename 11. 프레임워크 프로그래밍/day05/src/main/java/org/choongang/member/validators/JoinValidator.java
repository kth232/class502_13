package org.choongang.member.validators;


import lombok.RequiredArgsConstructor;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.mappers.MemberMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor //DI-생성자 매개변수
public class JoinValidator implements Validator { //validator를 정의해야 하는 경우 구현
    //Validator<RequestJoin>, RequiredValidator/ 사실 스프링이 제공하는 부분..

    private final MemberMapper mapper;

    @Override
    public boolean supports(Class<?> clazz) { // RequestJoin 커맨드 객체만 검증하도록 제한

        return clazz.isAssignableFrom(RequestJoin.class);
    }

    @Override
    public void validate(Object target, Errors errors) { //실제 검증 수행하는 부분
//         1. 필수 항목 검증(email, password, confirmPassword, userName, agree)
//         2. 이메일 중복 여부(가입되어 있는 회원인지 체크)
//         3. 비밀번호 자리수 체크(최소 8자리)
//         4. 비밀번호, 비밀번호 확인 일치 여부


        //validation에서 검증 가능한 부분
        RequestJoin form = (RequestJoin) target;
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String userName = form.getUserName();
        boolean agree = form.isAgree();

        /*
        //필수 항목 검증
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required", "enter your email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required", "enter your password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required", "confirm your password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required", "enter your name");

        if (!agree) {
            errors.rejectValue("agree", "Required", "회원 가입 약관에 동의하세요.");
        }
         */

        //2. 이메일 중복 여부 체크(회원이 가입되어 있는지 확인)
        if(StringUtils.hasText(email) && mapper.exists(email) != 0L) {
            errors.rejectValue("email", "Duplicated");
            //필드에 한정한 검증 실패 시 메세지
        }

        /*
        //3. 비밀번호 자리수 체크(8자리)
        if(StringUtils.hasText(password) && password.length() < 8) {
            errors.rejectValue("password", "length");
        }
         */

        //4. 비밀번호 확인 일치 여부
        if(StringUtils.hasText(password) && StringUtils.hasText(confirmPassword) && !password.equals(confirmPassword)) {
            errors.rejectValue("confirmPassword", "Passwords don't match");
        }

        /*
        if(!StringUtils.hasText(email)) {
            //email == null || email.isBlank() -> 자주 검증하는 내용은 스트링 프레임워크에서 제공함
            errors.rejectValue("email", "Required", "enter your email");
        }
        if(!StringUtils.hasText(password)) {
            errors.rejectValue("password", "Required", "enter your password");
        }
         */
    }


    /*
    private final MemberMapper mapper;
    
    @Override
    public void check(RequestJoin form) {

//         1. 필수 항목 검증(email, password, confirmPassword, userName, agree)
//         2. 이메일 중복 여부(가입되어 있는 회원인지 체크)
//         3. 비밀번호 자리수 체크(최소 8자리)
//         4. 비밀번호, 비밀번호 확인 일치 여부
        
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String userName = form.getUserName();
        boolean result = form.isAgree();

        //필수 항목 검증
        checkRequired(email, new BadRequestException("이메일을 입력하세요"));
        checkRequired(password, new BadRequestException("비밀번호를 입력하세요"));
        checkRequired(confirmPassword, new BadRequestException("비밀번호를 확인하세요"));
        checkRequired(userName, new BadRequestException("회원명을 입력하세요"));
        
        checkTrue(result, new BadRequestException("약관에 동의하세요"));

        //이메일 중복 여부
        checkTrue(mapper.exists(email) == 0L, new BadRequestException("이미 가입된 메일입니다"));

        //비밀번호 자리수 체크
        checkTrue(password.length() >= 8, new BadRequestException("비밀번호는 8자리 이상 입력해주세요"));

        //비밀번호, 비밀번호 확인 일치 여부
        checkTrue(password.equals(confirmPassword), new BadRequestException("비밀번호가 일치하지 않습니다"));
    }
    */
}
