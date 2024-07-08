package config;

import board.services.BoardService2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration //관리할 객체 설정, 컨테이너 안에 관리 객체가 존재해야 함
/*
@ComponentScan(basePackages = "member", 
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MenualBean.class)
)
//스캔 범위 설정 -> member 패키지를 포함한 하위 패키지 전부를 스캔 범위로 설정
//excludeFilters -> 자동 스캔 범위 대상에서 제외됨
 */

/*
@ComponentScan(basePackages = "member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {MemberDao.class, JoinValidator.class})
)
 */

/*
@ComponentScan(basePackages = "member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "member\\.*\\w*Dao")
)
//모든 문자열 0개 이상 Dao로 끝나는 정규표현식 패턴으로 배제
 */

/*
@ComponentScan(basePackages = {"member", "board"},
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern="member..*Dao")
)
// 배열 형태로 스캔 범위 추가 -> 스트링부트는 기본 패키지 범위를 스캔 범위로 자동 세팅
// aspectJ weaver - Ant 패턴으로 직관적인 필터링 가능
 */

@ComponentScan({"member", "board"})
public class AppCtx { //스프링 컨테이너가 객체 관리 시 참고할 설정 클래스
    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BoardService2 boardService2() {
        return new BoardService2();
    }
}