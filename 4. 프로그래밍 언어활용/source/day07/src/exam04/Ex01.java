package exam04;

public class Ex01 {
    public static void main(String[] args) {
        LoginService service = new LoginService();
        try {  //상황에 맞게 예외 처리할 수 있게 전가시킴
            service.login("user02", "123456");
        } catch (Exception e) { //<-UserIdException | UserPwException 다형성
            System.out.println(e.getMessage());
        }
    }
}
