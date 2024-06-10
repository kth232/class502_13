package member.services;

import global.Mailer;
import global.validators.Validator;
import jakarta.servlet.http.HttpServletRequest;

public class LoginService { //인터페이스 ->구현체 없음
    private Validator<HttpServletRequest> validator; //확장보단 구성
    private Mailer mailer;

    public LoginService(Validator<HttpServletRequest> validator) {
        this.validator = validator; //개방 폐쇄 원칙, 의존 역전 원칙 ->통제 위함, 전략 패턴
    } //의존 관게

    public void setMailer(Mailer mailer) {
        this.mailer = mailer;
    } //set함수를 통해 값 전달하면 연관 관계(의존 X)

    public void process(HttpServletRequest request) {
        validator.check(request);
        //로그인 성공 가정함
        //성공 시 메일 전송함
        if(mailer != null){
            String email = request.getParameter("email");
            mailer.send(email);
            //mailer.send(email);
        }

        /*
        //ID: email, PW: password 형태로 사용자 데이터 입력 받음
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //System.out.printf("email: %s, password: %s%n", email, password);

        //String test = request.getParameter("123");

        if (email == null || email.isBlank()) {
            throw new ValidationException("email을 입력하세요.");
        }
        */
    }
}
