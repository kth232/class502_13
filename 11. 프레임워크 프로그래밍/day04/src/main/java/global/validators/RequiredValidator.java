package global.validators;

public interface RequiredValidator { //사실 스프링에서 지원하는 부분..
    default void checkRequired(String str, RuntimeException e) {
        if (str == null || str.isBlank()) {
            throw e;
        }
    }

    default void checkTrue(boolean result, RuntimeException e) {
        if (!result) {
            throw e;
        }
    }
}
