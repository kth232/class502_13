package org.choongang.global.validators;

public interface RequiredValidator {
    //디폴트 메서드로 구현
    //입력값이 없거나 비어있으면 예외 던짐
    default void checkRequired(String str, RuntimeException e){
        if (str == null || str.isBlank()){
            throw e;
        }
    }
    //참인지 체크, 체크가 안되어있으면 예외 던짐
    default void checkTrue(boolean checked, RuntimeException e){
        if (!checked) {
            throw e;
        }
    }
}
