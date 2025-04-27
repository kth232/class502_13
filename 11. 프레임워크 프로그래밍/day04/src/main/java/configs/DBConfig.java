package configs;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration //설정 클래스로 인식
@MapperScan("mappers") //자동 매퍼 스캔
@EnableTransactionManagement //트랜젝션 관리
public class DBConfig {
    //DB 관련 세팅!

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
        ds.setTestWhileIdle(true); //유휴 객체 유효성 체크, SELECT 1 FROM DUAL
        ds.setInitialSize(2); //처음 로드 시 생성할 커넥션 객체의 개수
        ds.setMaxActive(10); //최대 활성 커넥션 객체의 개수
        ds.setTimeBetweenEvictionRunsMillis(10 * 1000); //10초에 한번씩 연결 상태 체크
        ds.setMinEvictableIdleTimeMillis(1000 * 60); //유휴 객체 생존 시간 1분->소멸 후 다시 생성됨
        /*커넥션 풀 설정 E*/

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());

        return tm;
    }

    @Bean //마이바티스 설정
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource()); //dataSource를 가지고 생성

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject(); //세션 관리 객체
        return sqlSessionFactory;
    }
}
