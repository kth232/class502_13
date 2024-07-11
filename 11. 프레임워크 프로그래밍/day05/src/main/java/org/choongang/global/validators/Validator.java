package org.choongang.global.validators;

public interface Validator<T> {
    void check(T form);
    //필수 사항 검증
}
