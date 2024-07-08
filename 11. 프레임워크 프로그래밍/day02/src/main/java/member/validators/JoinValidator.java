package member.validators;

import global.validators.Validator;
import member.controllers.RequestJoin;
import member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //구성 요소의 특징이 강하므로 Service보단 Component 애노테이션 붙임(의미적인 구분 위함, 컴파일러는 똑같이 인식함)
public class JoinValidator implements Validator<RequestJoin> {

    private MemberDao memberDao;

    //@Qualifier("mDao") //빈 이름 지정
    @Autowired //스프링 컨테이너 내부의 객체 찾아서 주입, 호출
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public void check(RequestJoin form) {

    }
}
