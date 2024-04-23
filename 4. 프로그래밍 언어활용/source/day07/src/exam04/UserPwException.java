package exam04;

public class UserPwException extends RuntimeException{ //Exception보다 유연한 예외처리, Exception은 형식 명시해야 함
    public UserPwException(String message){
        super(message);
    }
}
