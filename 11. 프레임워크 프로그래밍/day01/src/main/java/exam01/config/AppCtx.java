package exam01.config;

import exam01.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//설정 클래스-스프링 컨테이너가 관리할 객체를 정의, 설정
//@Import(value={AppCtx2.class}) //value는 하나만 있을 경우 생략 가능
//@Import({AppCtx2.class}) //중괄호로 감싼 경우 여러개면 콤마로 구분 가능?
@Import(AppCtx2.class) //다른 설정 클래스를 import함, value가 기본 속성
@Configuration //설정 클래스임을 알려줘야 함, 프레임워크 내부에 있는 애노테이션
public class AppCtx {

    @Bean //관리할 객체임을 알려줘서 컨테이너 안에 담아줌
    public Greeter greeter() {

        return new Greeter();
    }
}
