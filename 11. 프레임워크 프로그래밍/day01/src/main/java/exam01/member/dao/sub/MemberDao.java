package exam01.member.dao.sub;

import org.springframework.stereotype.Component;

@Component("memberDao2") //이름을 다르게 지정해주면 충돌 x
public class MemberDao { //패키지가 다르기 때문에 서로 다른 클래스임
    //하지만 빈 이름은 클래스명만 고려함, 다른 패키지에 있어도 동일한 이름의 클래스가 있으면 충돌 발생

}
