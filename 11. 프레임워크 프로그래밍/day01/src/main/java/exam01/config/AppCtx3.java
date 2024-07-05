package exam01.config;

import exam01.member.dao.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //스프링이 관리할 객체임을 알려주는 애노테이션
//@ComponentScan(basePackages = "exam01.member") //멤버 패키지를 포함한 하위 범위를 스캔 대상으로 설정
@ComponentScan("exam01.member")
public class AppCtx3 { //객체 조립기 역할을 대신해주는 스프링

    @Bean
    public MemberDao memberDao() { //충돌을 방지하기 위해 수동 등록 빈이 자동 스캔보다 우선 순위 높음
        System.out.println("수동 등록 bean");
        return new MemberDao();
    }

    /*
    //자료형이 같은 수동 등록 빈이 2개면 어떤 걸 선택해야 하는지 모르기 때문에 에러 발생함
    @Bean
    public MemberDao memberDao2() {
        System.out.println("수동 등록 bean2");
        return new MemberDao();
    }
    */
}
