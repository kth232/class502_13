package configs;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBConn {
    private static SqlSessionFactory factory; //SqlSessionFactory 객체 생성, 정적 자원
    static {
        try{
        Reader reader = Resources.getResourceAsReader("configs/mybatis-config.xml"); //문자 단위로 파일 읽어오는 reader 객체
        factory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSession(boolean autoCommit) { //SqlSession 받기
        return factory.openSession(autoCommit);
    }
    public static SqlSession getSession() {
        return getSession(true); //autoCommit =true
    }
}
