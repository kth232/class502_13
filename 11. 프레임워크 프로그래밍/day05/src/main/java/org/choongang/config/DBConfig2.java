package org.choongang.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@Configuration //설정 클래스로 인식
public class DBConfig2 { //빈 분리를 위해 정적 내부 클래스로 분리
    //환경변수에 따라 프로파일 설정->빈 객체 다르게 생성
    //개발 환경과 실제 환경이 다르기 때문에 프로파일 설정 분리
    //dev는 배제->개발자마다 환경이 다르기 때문에 핵심 설정만 올려주고 별도로 환경 설정하도록 함

    @Profile("!prod") //개발 시 프로파일
    @Configuration //설정 클래스로 인식
    @EnableTransactionManagement //트랜젝션 관련 설정
    @MapperScan("org.choongang") //매퍼 자동 스캔
    @EnableJdbcRepositories("org.choongang") //jdbc 활성화
    static class DBConfigDev extends AbstractJdbcConfiguration {

        @Bean(destroyMethod = "close") //메서드 종료 시 
        public DataSource dataSource() {
            log.info("dev profile");
            DataSource ds = new DataSource();
            
            //연결 설정 S
            //계정을 직접 입력해서 설정하면 해킹 위험 높음->환경변수로 설정
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
            ds.setUsername("SPRING");
            ds.setPassword("oracle");
            //연결 설정 E

            //DB 서버와 연결=커넥션
            //커넥션 풀 설정 S
            ds.setInitialSize(2); //최초 생성 개수 2개
            ds.setMaxActive(10); //최대 10개 커넥션 유지
            ds.setTestOnBorrow(true); //연동 중인지 체크
            ds.setMinEvictableIdleTimeMillis(1000 * 60); //1분간 연결 살아있음(기본값)
            ds.setTimeBetweenEvictionRunsMillis(1000 * 5); //5초마다 체크
            //커넥션 풀 설정 E

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
        public SqlSessionFactory sqlSessionFactory() throws Exception {//마이바티스 설정
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource());

            return factoryBean.getObject();
        }

        @Bean
        public NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
            return new NamedParameterJdbcTemplate(dataSource);
        }
    }
    
    @Profile("prod") //배포 시 프로파일
    @Configuration //설정 클래스로 인식
    @EnableTransactionManagement //트랜젝션 관련 설정
    @MapperScan("org.choongang") //매퍼 자동 스캔
    @EnableJdbcRepositories("org.choongang") //jdbc 활성화
    static class DBConfigProd extends AbstractJdbcConfiguration { //DB 설정 클래스 분리->내부 클래스로 분리

        @Bean(destroyMethod = "close") //메서드 종료 시 
        public DataSource dataSource() {
            log.info("prod profile");
            DataSource ds = new DataSource();

            //연결 설정 S
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
            ds.setUsername("SPRING");
            ds.setPassword("oracle");
            //연결 설정 E

            //DB 서버와 연결=커넥션
            //커넥션 풀 설정 S
            ds.setInitialSize(2); //최초 생성 개수 2개
            ds.setMaxActive(10); //최대 10개 커넥션 유지
            ds.setTestOnBorrow(true); //연동 중인지 체크
            ds.setMinEvictableIdleTimeMillis(1000 * 60); //1분간 연결 살아있음(기본값)
            ds.setTimeBetweenEvictionRunsMillis(1000 * 5); //5초마다 체크
            //커넥션 풀 설정 E

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
        public SqlSessionFactory sqlSessionFactory() throws Exception {//마이바티스 설정
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource());

            return factoryBean.getObject();
        }

        @Bean
        public NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
            return new NamedParameterJdbcTemplate(dataSource);
        }
    }
}
