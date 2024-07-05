package exam01.member.validators;

import exam01.global.validators.Validator;
import exam01.member.controllers.RequestJoin;
import exam01.member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
