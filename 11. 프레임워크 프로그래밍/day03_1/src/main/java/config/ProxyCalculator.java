package config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect //공통 기능 클래스
public class ProxyCalculator {

    //exam01 패키지를 포함한 하위 모든 클래스에 적용
    @Pointcut("execution(* exam01..*(..))") //포인트컷: 적용 범위 지정 가능, 별도 표현식 사용
    public void publicTarget() {}
    
    @Before("publicTarget()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before");
    }

    @After("publicTarget()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after");
    }

    @AfterReturning(value = "publicTarget()", returning = "returnValue") //returnValue 지정
    public void afterReturning(JoinPoint joinPoint, Object returnValue) throws Throwable {
        //반환값 타입이 매개변수로 넘어옴
        System.out.println("afterReturning: " + returnValue);
    }

    @AfterThrowing(value="publicTarget()", throwing = "e") //유입되는 예외 지정
    public void afterThrowing(JoinPoint joinPoint, Throwable e) throws Throwable {
        System.out.println("afterThrowing: " + e);
    }


    @Around("publicTarget()") //메서드 호출 전, 후에 공통 기능
    public Object process (ProceedingJoinPoint joinPoint) throws Throwable {
        //범용적으로 적용해야 하기 때문에 반환값 타입은 Object, 메서드명은 변경 가능

        /*
        Signature sig = joinPoint.getSignature(); //호출한 메서드 정의 정보
        System.out.println(sig.toLongString());
        
        Object[] args = joinPoint.getArgs(); //인수 정보
        System.out.println(Arrays.toString(args));
        
        Object obj = joinPoint.getTarget(); //호출한 메서드를 가지고 있는 객체
        System.out.println(obj.getClass());
        */
        
        long stime = System.nanoTime(); //공통 기능
        try {
            //System.out.println("inflow"); //해당 메서드를 거쳐 옴, 범위에 해당하는 클래스와 메서드에 동일하게 적용 가능

            Object result = joinPoint.proceed(); //핵심 기능 대신 실행 -factorial

            boolean re = false;
            if(!re) {
                throw new RuntimeException("예외 테스트");
            }

            return result;
        } finally {
            long etime = System.nanoTime(); //공통 기능
            System.out.printf("소요 시간: %d%n", etime - stime);
        }
    }
}
