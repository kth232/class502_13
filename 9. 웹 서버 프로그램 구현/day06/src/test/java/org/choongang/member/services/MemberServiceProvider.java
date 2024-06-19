package org.choongang.member.services;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.configs.DBConn;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.validators.JoinValidator;

//회원가입 기능에 특화된 객체 조립기
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

    public MemberMapper memberMapper() {
        SqlSession session = DBConn.getSession();
        return session.getMapper(MemberMapper.class);
    }

    //회원가입 검증
    public JoinValidator joinValidator() {
        return new JoinValidator(memberMapper());
    }

    public JoinService joinService() {
        return new JoinService(joinValidator(), memberMapper());
    }
}
