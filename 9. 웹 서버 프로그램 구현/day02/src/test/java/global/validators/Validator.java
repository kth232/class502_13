package global.validators;

public interface Validator<T> { //다중 상속, 다형성 사용->유연성 좋음
    void check(T form); //검증 역할 담당
}
