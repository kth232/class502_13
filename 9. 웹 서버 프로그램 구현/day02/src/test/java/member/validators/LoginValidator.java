package member.validators;

import global.exceptions.ValidationException;
import global.validators.Validator;
import jakarta.servlet.http.HttpServletRequest;

public class LoginValidator implements Validator<HttpServletRequest>, RequiredValidator {
    @Override
    public void check(HttpServletRequest form){ //검증 역할 담당, 단일 기능 원칙
        String email = form.getParameter("email");
        /*
        if (email == null || email.isBlank()){
            throw new ValidationException("enter your email.");
        }
        */
        String password = form.getParameter("password");

        //필수 항목 검증 S
        checkRequired(email, new ValidationException("enter your email"));
        checkRequired(password, new ValidationException("enter your password"));
        //필수 항목 검증 E
    }
}
