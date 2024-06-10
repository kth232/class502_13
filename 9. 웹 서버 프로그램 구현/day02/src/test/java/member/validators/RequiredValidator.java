package member.validators;

public interface RequiredValidator {
    default void checkRequired(String str, RuntimeException e) { //다양한 예외 throw -> 다형성 사용: RuntimeException
        if(str == null || str.isBlank()) {
            throw e;
        }
    }
}
