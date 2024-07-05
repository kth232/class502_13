package exam01.config;

import exam01.member.dao.MemberDao;
import exam01.member.services.InfoService;
import exam01.member.services.JoinService;
import exam01.member.validators.JoinValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration //스프링이 관리할 객체임을 알려주는 애노테이션
public class AppCtx2 { //객체 조립기 역할을 대신해주는 스프링

    @Qualifier("mDao")
    @Bean //bean 애노테이션이 없으면 컨테이너 내부에 객체 없는 상태 -> 의존성 주입 안됨
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean //메서드명이 빈의 이름, 자료형이 동일한 경우 어떤 빈을 매칭할지 결정 못함->오류 발생->이름을 지정해주면 됨
    public MemberDao memberDao2() {
        return new MemberDao();
    }

    @Bean
    public JoinValidator joinValidator() {
        JoinValidator joinValidator = new JoinValidator();
        //joinValidator.setMemberDao(memberDao()); //없으면 객체 주입 안되서 NullPointException 발생
        return joinValidator;
    }

    @Bean
    public JoinService joinService() {
        //return new JoinService(joinValidator(), memberDao());
        return new JoinService();
    }

    @Bean
    public InfoService infoService() {
        InfoService infoService = new InfoService();
        //infoService.setMemberDao(memberDao());

        return infoService;
    }

    @Bean //자바 JDK, 외부 라이브러리는 수동 등록 필수, 사용자가 만든 건 자동 스캔함
    public DateTimeFormatter dateTimeFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return formatter;
    }
}
