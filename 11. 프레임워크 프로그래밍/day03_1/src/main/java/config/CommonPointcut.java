package config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CommonPointcut {
    @Pointcut("execution(* exam01..*(..))") //포인트컷을 따로 분리해서 관리 가능
    public void publicTarget() {

    }
}
