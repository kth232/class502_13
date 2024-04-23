package exam04;

public class LoginService {
    public void login(String userId, String userPw) throws UserIdException, UserPwException { //함수 구분 문구
        // 상황에 맞게 예외 처리할 수 있게 전가시킴
        // userId - user01, userPw = 123456
        try {
            if (!userId.equals("user01")) {
                throw new UserIdException("아이디가 일치하지 않습니다.");
            }
            if (!userPw.equals("123456")) {
                throw new UserPwException("비밀번호가 일치하지 않습니다.");
            }
            System.out.println("로그인 성공!");
        } catch (UserIdException | UserPwException e) {
            System.out.println(e.getMessage());
        }
    }
}
