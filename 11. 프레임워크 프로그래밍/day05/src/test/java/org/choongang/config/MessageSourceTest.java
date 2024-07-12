package org.choongang.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.Locale;

@SpringJUnitWebConfig
@ContextConfiguration(classes = MvcConfig.class)
public class MessageSourceTest {

    @Autowired
    private MessageSource messageSource;

    @Test
    void test01() {
        //String message = messageSource.getMessage("LOGIN_MSG", new Object[] {"유저01", "user01"}, Locale.KOREAN);
        String message = messageSource.getMessage("LOGIN_MSG", new Object[] {"유저01", "user01"}, Locale.ENGLISH);
        System.out.println(message);
    }

    @Test
    void test02() {
        //String message = messageSource.getMessage("EMAIL", null, Locale.KOREAN);
        String message = messageSource.getMessage("EMAIL", null, Locale.ENGLISH);
        System.out.println(message);
    }
}
