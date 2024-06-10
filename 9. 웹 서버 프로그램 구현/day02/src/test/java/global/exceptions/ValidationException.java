package global.exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) { //다양한 예외상황에 대한 메세지 출력
        super(message);
    }
}
