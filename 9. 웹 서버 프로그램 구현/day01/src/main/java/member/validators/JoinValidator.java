package member.validators;

import global.exceptions.ValidationException;
import global.validators.RequiredValidator;
import global.validators.Validator;
import member.controllers.RequestJoin;

public class JoinValidator implements Validator<RequestJoin>, RequiredValidator {

    @Override
    public void check(RequestJoin form) {
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String userName = form.getUserName();
        boolean termsAgree = form.isTermsAgree();

        /* 필수 항목 검증 S */
        //테스트할 값과 키워드 일치시킬 것!
        checkRequired(email, new ValidationException("email"));
        checkRequired(password, new ValidationException("password"));
        checkRequired(confirmPassword, new ValidationException("confirm password"));
        checkRequired(userName, new ValidationException("userName"));
        checkTrue(termsAgree, new ValidationException("agree terms"));
        /*
        if (!termsAgree) {
            throw new ValidationException("agree terms");
        } //통일성 있게 만들고 싶다-> requiredValidator 인터페이스에 추가
        */
        /* 필수 항목 검증 E */
    }
}
