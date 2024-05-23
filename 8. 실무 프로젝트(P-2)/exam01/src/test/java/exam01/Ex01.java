package exam01;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.time.LocalDateTime;

public class Ex01 {
    @Test
    void test1() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //DB 접속 위한 드라이버
        } catch(ClassNotFoundException e){ //클래스 예외 처리
            e.printStackTrace();
        }
        //서버 주소, 포트번호는 상황에 맞게 입력
        String url = "jdbc:oracle:thin:@localhost:1521:XE"; //EE, 엔터프라이즈 버전 사용 시
        String user = "STUDY"; //SCOTT
        String password = "oracle"; //tiger
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement() //statement 객체 생성, DML문 사용 가능
        ){
            String sql = "INSERT INTO MEMBER(USER_NO, USER_ID, USER_PW, USER_NM, MOBILE) VALUES (SEQ_MEMBER.NEXTVAL, 'USER02', '123456', 'USER02','01000000000')";

            int cnt = stmt.executeUpdate(sql);
            System.out.println(cnt);
        } catch (SQLException e) { //try with resource 구문
            e.printStackTrace();
        }
    }
    @Test
    void test2() {
        try {
            //오라클 드라이버 동적 로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "STUDY";
        String password = "oracle";
        try(Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement()
        ) {
            String keyword = "USER"; //SQL 주입 가능성 높음->해킹 위험
            String sql = "SELECT * FROM MEMBER WHERE USER_NM LIKE '%"+keyword +"%'";

            ResultSet rs = stmt.executeQuery(sql); //이동하면서 하나씩 읽어옴
            while(rs.next()){
                long userNo = rs.getLong("USER_NO"); //조회된 순서대로 값 가져오면 순서 변경 시 오류 발생
                String userId = rs.getNString("USER_ID"); //컬럼명으로 가져오는 것이 좋다
                String userPw = rs.getNString("USER_PW");
                String userNm = rs.getNString("USER_NM");
                String mobile = rs.getNString("MOBILE");
                LocalDateTime regDt = rs.getTimestamp("REG_DT").toLocalDateTime(); //LocalDateTime으로 변환
                System.out.printf("USER_NO:%d, USER_ID:%s, USER_PW:%s, USER_NM: %s, MOBILE:%s, REG_DT:%s%n", userNo, userId, userPw, userNm, mobile, regDt);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
