package org.choongang.global.configs;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJdbcRepositories("org.choongang") //레포지토리 스캔범위 설정
public class DBConfig extends AbstractJdbcConfiguration {
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();

        /* 데이터베이스 연결 설정 S */
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://code-factory.co.kr:3306/CONSOLE_BOARD");
        ds.setUsername("CONSOLE_BOARD");
        ds.setPassword("_aA123456");

        /* 커넥션 풀 설정 */
        ds.setInitialSize(2); // 처음 로드시 생성할 커넥션 객체의 갯수
        ds.setMaxActive(10); // 최대 활성 커넥션 객체의 갯수
        ds.setTestWhileIdle(true); // SELECT 1 FROM DUAL, 유휴 객체 연결 테스트

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
