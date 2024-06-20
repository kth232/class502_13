package org.choongang.member.services;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.configs.DBConn;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;

//회원가입 기능에 특화된 객체 조립기 ->통제 위함
public class MemberServiceProvider {
    //싱글톤 패턴
    private static MemberServiceProvider instance;

    private MemberServiceProvider() {}

    public static MemberServiceProvider getInstance() {
        if (instance==null){
            instance = new MemberServiceProvider();
        }
        return instance;
    }

    public SqlSession getSession() {
        return DBConn.getSession();
    }

    public MemberMapper memberMapper() {
        return getSession().getMapper(MemberMapper.class);
    }

    //회원가입 검증
    public JoinValidator joinValidator() {
        return new JoinValidator(memberMapper());
    }

    public JoinService joinService() {
        return new JoinService(joinValidator(), memberMapper());
    }

    //login 검증
    public LoginValidator loginValidator() {
        return new LoginValidator(memberMapper());
    }

    public LoginService loginService() {
        return new LoginService(loginValidator(), memberMapper());
        //의존성 추가 시 매개변수 추가
    }
}
