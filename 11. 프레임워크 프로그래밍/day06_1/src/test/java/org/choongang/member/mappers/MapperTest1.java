package org.choongang.member.mappers;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.choongang.global.configs.AppCtx;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(AppCtx.class)
public class MapperTest1 {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession session;

    @Autowired
    private MemberMapper memberMapper;

    @BeforeEach
    void init() {
        session = sqlSessionFactory.openSession(true);
        System.out.println(session);
    }

    @Test
    void test1() {
        List<Member> items = session.selectList("org.choongang.member.mappers.MemberMapper.getList");
        items.forEach(System.out::println);
    }

    @Test
    void test2() {
//        List<Member> items = memberMapper.getList();
//        items.forEach(System.out::println);
    }

    @Test
    void test3() {
        //Member item = memberMapper.get("user01@test.org").orElseGet(Member::new);
        //Member item = memberMapper.get("user01@test.org").orElse(null);
        //Member item = memberMapper.get("user01@test.org").orElseThrow(IllegalArgumentException::new);
        //System.out.println(item);

        //Member item = memberMapper.get("user02@test.org", 3L).orElse(null);
        //System.out.println(item);
    }

    @Test
    void test4() {
        Member member = new Member();
        member.setEmail("user1101@test.org");
        member.setName("user1101");
        member.setPassword("12345678");
        member.setMobile("01011112222");
        member.setTerms(true);
        int affectedRows =  memberMapper.register(member);
        System.out.println(affectedRows);

        System.out.println(member);
    }

    @Test
    void test5() {
        Member member = new Member();
        member.setEmail("user1101@test.org");
        member.setPassword("(수정)12345678");
        member.setName("(수정)user1101");
        member.setMobile("(수정)01011112222");

        memberMapper.update(member);

        Member member2 = memberMapper.get("user1101@test.org").orElse(null);
        System.out.println(member2);
    }
}
