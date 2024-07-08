package member.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.controllers.RequestJoin;
import member.dao.MemberDao;
import member.entities.Member;
import member.validators.JoinValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service //관리 객체, 서비스의 특징이 강하기 때문에 Service 애노테이션 붙임(Component도 가능)
@RequiredArgsConstructor() //lombok, 생성자 주입, final 사용 가능, @NonNull 필드의 생성자 생성
public class JoinService {
    //@Autowired //컨테이너 안에서 객체 찾아서 주입해줌=의존성 주입
    private JoinValidator validator;

    //@Qualifier("mDao")
    //@Autowired //의존성 주입
    @NonNull //null값이 아님, 생성자 매개변수에 추가됨
    private MemberDao memberDao;

    /*
    //의존 관계(생성자)-없으면 객체 생성 불가(필수)
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
