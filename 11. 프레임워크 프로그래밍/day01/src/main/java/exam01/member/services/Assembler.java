package exam01.member.services;

import exam01.member.dao.MemberDao;
import exam01.member.validators.JoinValidator;

public class Assembler { //객체 조립기 역할 -> 스프링이 대신해줌
    public MemberDao memberDao() {
        return new MemberDao();
    }

    public JoinValidator joinValidator() {
        JoinValidator validator = new JoinValidator();
        validator.setMemberDao(memberDao());
        return validator;
    }

    //의존성이 추가될 경우 여기에 추가해주면 사용하는 객체에 전부 적용
    public JoinService joinService() { 
        //return new JoinService(joinValidator(), memberDao());
        return new JoinService();
    }
}
