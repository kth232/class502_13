package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect //공통 기능 클래스
@Order(2)
public class ProxyCalculator2 {
    /*
    @Pointcut("execution(* exam01..*(..))") //exam01를 포함한 하위 패키지 모든 매개변수
    public void publicTarget() {}
     */

    //@Around("publicTarget()")
    //@Around("execution(* exam01..*(..))") //포인트컷을 @Around에 한꺼번에 정의할 수 있음
    @Around("config.CommonPointcut.publicTarget()") //포인트컷을 분리하는 경우 경로 입력(같은 패키지인 경우 패캐지명 생략 가능)
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        long stime = System.nanoTime();
        try {
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long etime = System.nanoTime();
            System.out.printf("time: %d%n", etime - stime);
        }
    }
}
