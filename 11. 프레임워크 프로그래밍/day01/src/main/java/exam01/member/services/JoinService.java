package exam01.member.services;

import exam01.member.controllers.RequestJoin;
import exam01.member.dao.MemberDao;
import exam01.member.entities.Member;
import exam01.member.validators.JoinValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

//@Component
@Service
//@RequiredArgsConstructor
public class JoinService {
    @Autowired //컨테이너 안에서 객체 찾아서 주입해줌
    private JoinValidator validator;

    //@Qualifier("mDao")
    @Autowired
    private MemberDao memberDao;

    //@NonNull
    //private final MemberDao memberDao;

    /*
    //의존 관계(생성자)-없으면 객체 생성 불가(필수)
    //@Autowired를 사용하지 않아도 자동 주입, 스프링 컨테이너가 객체를 관리하려면 객체 생성 필수!
    //생성자 매개변수가 해결되지 않으면 객체 생성 불가
    public JoinService(JoinValidator validator, MemberDao memberDao) {
        this.validator = validator;
        this.memberDao = memberDao;
    }
     */

    /*
    //연관 관계-객체를 만든 후 주입함, 없어도 객체 생성됨(필수x)
    public void setValidator(JoinValidator validator) {
        this.validator = validator;
    }
    */
    public void process(RequestJoin form) {
        validator.check(form); //joinService는 validator 객체, form 객체를 의존->의존성

        //데이터 영구 저장 -DAO(Data Access Object)
        Member member = Member.builder()
                .email(form.getEmail())
                .password(form.getPassword())
                .userName(form.getUserName())
                .regDt(LocalDateTime.now())
                .build();

        memberDao.register(member);
    }
}
