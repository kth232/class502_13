package org.choongang.configs;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.configs.DBConn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class DBConnTest {

    @Test
    @DisplayName("DB connection test")
    void dbConnectionTest() {
        assertDoesNotThrow(()->{
            SqlSession session = DBConn.getSession(); //DBsession 연결
            System.out.println(session);
            //DBsession: 데이터베이스에 접속한 후 종료하기까지의 과정, db 접속=커넥션
            //transaction: 작업 수행 단위
        });
    }
}
