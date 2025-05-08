package org.choongang.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Import(DBConfig.class)
@Configuration
@ComponentScan("org.choongang")
public class AppCtx {
}
