package member.services;

import global.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import mappers.member.MemberMapper;
import member.controllers.RequestJoin;
import member.entities.Member;
import member.validators.JoinValidator;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service //컴포넌트 스캔 대상
@RequiredArgsConstructor //자동 의존 주입-생성자 매개변수
public class JoinService {
    
    //@Autowired
    private final JoinValidator validator;
    private final MemberMapper mapper;

    public void process(RequestJoin form) {
        //유효성 검사
        validator.check(form);

        //비밀번호 해시화
        String hash = BCrypt.hashpw(form.getPassword(), BCrypt.gensalt(12));
        
        //DB 저장
        Member member = Member.builder()
                .email(form.getEmail())
                .password(hash)
                .userName(form.getUserName())
                .build();

        int result = mapper.register(member);
        if (result < 1) {
            throw new BadRequestException("join fail");
        }
    }
}
