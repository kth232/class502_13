package exam01;

import exam01.member.controllers.RequestJoin;
import exam01.member.dao.MemberDao;
import exam01.member.entities.Member;
import exam01.member.services.Assembler;
import exam01.member.services.JoinService;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Ex02 {
    @Test
    void test01() {
        Assembler assembler = new Assembler(); //객체 조립
        JoinService joinService = assembler.joinService();
        MemberDao memberDao = assembler.memberDao();

        RequestJoin form = RequestJoin.builder()
                .email("user01@test.org")
                .userName("user01")
                .password("12345678")
                .confirmPassword("12345678")
                .build();

        joinService.process(form);

        List<Member> members = memberDao.getList();
        members.forEach(System.out::println);
    }
}
