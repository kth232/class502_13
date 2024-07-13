package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Aspect //공통 기능 클래스
@Order(1) //순서 지정
public class ProxyCache {
    Map<Long, Object> data = new HashMap<>(); //첫번째 인자를 long 타입으로 구함
    /*
    @Pointcut("execution(* exam01..*(..))") //적용 범위 설정
    public void publicTarget() {}
    
    @Around("publicTarget()") //@Pointcut 설정은 첫 번째 인자가 long인 메서드를 대상
    // -> execute()는 Calculator의 factorial(long) 메서드에 적용
    */
    @Around("CommonPointcut.publicTarget()") //포인트컷을 따로 분리해서 사용하는 경우 경로 입력(같은 패키지인 경우 패캐지명 생략 가능)
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        Long num = (Long)args[0];
        if(data.containsKey(num)) { //이미 캐시에 저장된 결과 값이 있으면 사용, 저장된 값을 출력하면 소요 시간은 출력 안됨
            System.out.println("use cache");

            return data.get(num);
        }

        Object result = joinPoint.proceed(); //핵심 기능 수행하는 메서드
        data.put(num, result); //캐시에 저장
        System.out.println("save cache");

        return result;
    }
}
