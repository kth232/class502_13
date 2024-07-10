package global.exceptions;

public class CommonException extends RuntimeException{ //공통 예외
    public CommonException(String message){
        super(message);
    }
}
