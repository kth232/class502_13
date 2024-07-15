package org.choongang.member.mappers;

import org.choongang.config.MvcConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

@SpringJUnitWebConfig //extendWith, contextConfiguratioin 등의 설정이 포함됨 ->테스트 시 자주 사용
@ContextConfiguration(classes = MvcConfig.class) //클래스 파일 명시하기 위해 작성
public class MapperTest {
    
    @Autowired
    private MemberMapper mapper;

    @Test
    void test01(){
        long total = mapper.getTotal();
        System.out.println(total);
    }

    @Test
    void test02() {
      long cnt = mapper.exists("user01@test.org");
      System.out.println(cnt);
    }
}
