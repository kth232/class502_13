package org.choongang.global.configs;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBConn {
    //sqlsession 생성 및 연결
    //session factory 객체 생성
    private static SqlSessionFactory factory;

    static {
        try { //빌더로 리소스 읽어오기
        Reader reader = Resources.getResourceAsReader("org/choongang/global/configs/mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(reader);
    } catch (IOException e){
        e.printStackTrace();
        }
    }

    public static SqlSession getSession(boolean autoCommit) {
        return factory.openSession(autoCommit);
    }

    public static SqlSession getSession() {
        return getSession(true); //오토커밋 true
    }
}
