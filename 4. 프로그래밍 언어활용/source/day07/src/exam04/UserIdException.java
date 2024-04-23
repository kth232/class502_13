package exam04;

public class UserIdException extends RuntimeException { //형식에 유연함
    public UserIdException(String message) {
        super(message);
    }
}
