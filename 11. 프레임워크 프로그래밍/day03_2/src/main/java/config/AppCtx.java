package config;

import org.apache.tomcat.jdbc.pool.DataSource; //tomcat jdbc인지 확인하기
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppCtx {

    @Bean(destroyMethod = "close") //스프링 컨테이너가 소멸될 때 자원 해제도 자동 소멸됨
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        /*DB 연결 설정 S*/
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        ds.setUsername("SPRING");
        ds.setPassword("oracle");
        /*DB 연결 설정 E*/

        /*커넥션 풀 설정 S*/
        ds.setTestWhileIdle(true); //유휴 객체 유효성 체크
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTimeBetweenEvictionRunsMillis(10 * 1000); //10초에 한번씩 연결 상태 체크
        ds.setMinEvictableIdleTimeMillis(1000 * 60); //유휴 객체 생존 시간 1분->소멸 후 다시 생성됨
        /*커넥션 풀 설정 E*/

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
