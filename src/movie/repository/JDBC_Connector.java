package movie.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Connector {
    // 1. DB 연결 설정 정보
    private static final String DRIVER_PATH = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
    private static final String USER_NAME = "c##movie_sniper";
    private static final String PASSWORD = "1234";

    // 2. DB 연결 객체 반환
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DRIVER_PATH);
            // System.out.println("JDBC Driver Loaded"); //* 불필요한 로그는 주석 처리하였습니다.
            con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Not Found");
        } catch (SQLException e) {
            System.out.println("Connection Error");
        }
        return con;
    }

    //* 3. 자원 해제 (수업에서는 매번 try-catch로 닫았으나, 중복 코드를 줄이기 위해 통합 메소드를 추가하였습니다.)
    public static void close(ResultSet rs, PreparedStatement psmt, Connection con) {
        try {
            if (rs != null) rs.close();
            if (psmt != null) psmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}