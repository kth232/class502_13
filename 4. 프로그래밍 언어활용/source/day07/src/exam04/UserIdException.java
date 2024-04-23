package exam04;

public class UserIdException extends RuntimeException { //<-형식에 유연함 
    public UserIdException(String message) { //사용자 정의 예외
        super(message);
    }
}// 파일명에 Exception 붙여서 예외처리인 것 알리기->관례
