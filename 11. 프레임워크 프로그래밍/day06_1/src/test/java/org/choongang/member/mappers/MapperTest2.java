package org.choongang.member.mappers;

import org.choongang.global.CommonSearch;
import org.choongang.global.configs.AppCtx;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(AppCtx.class)
public class MapperTest2 {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    void test() {
        CommonSearch search = new CommonSearch();
//        search.setSopt("email");
//        search.setSkey("%user%");
        search.setSkey("user"); // %user%
        search.setOffset(0);
        search.setLimit(5);
        search.setSeq(1L);

        List<Member> items = memberMapper.getList(search);
        items.forEach(System.out::println);
    }

    @Test
    void test2() {
        List<Member> items = memberMapper.getList2(List.of(3L, 4L, 5L));
        items.forEach(System.out::println);
    }

    @Test
    void test3() {
        long total = memberMapper.getTotal();
        System.out.println(total);


        long total2 = memberMapper.getTotal2("%user%");
        System.out.println(total2);
    }
}
