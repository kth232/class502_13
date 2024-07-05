package exam01.member.services;

import exam01.member.dao.MemberDao;
import exam01.member.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class InfoService {

    private MemberDao memberDao;

    //private DateTimeFormatter formatter;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd");
    //formatter 기본값 정의



    //@Qualifier("mDao") //빈 이름 지정
    @Autowired
    public void setMemberDao(Optional<MemberDao> opt) {
        this.memberDao = opt.get();
    }


    @Autowired(required = false) //DateTimeFommatter 빈이 없으면 -> 호출 x(실행 안됨, 무시함)
    public void setFormatter(DateTimeFormatter formatter) {
        System.out.println("call()");
        this.formatter = formatter;
    }

    /*
    @Autowired //실행되어 null 값으로 주입-> 호출 o -> 단, null값으로 대입되어서 기본값으로 정의된 포맷 적용 안됨
    public void setFormatter(@Nullable DateTimeFormatter formatter) { //@Nullable 없을 수도 있는 객체 -> 필수 여부 해제
        System.out.println("call()");
        this.formatter = formatter;
    }
    */

    public void printList() {
        List<Member> members = memberDao.getList();
        members.forEach(m -> {
            System.out.println(m);
            LocalDateTime regDt = m.getRegDt();
            if (formatter != null) {
                System.out.println(formatter.format(regDt));
            }
        });
    }
}
