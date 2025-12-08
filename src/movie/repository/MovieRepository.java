package movie.repository;

import movie.domain.MovieVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieRepository {
    ArrayList<MovieVO> movieVOList;

    // 1. 영화 목록 조회 및 검색 (BookRepository의 select 메소드와 동일한 구조)
    // selectedIndex: 0(제목), 1(장르), 2(감독)
    public ArrayList<MovieVO> select(String searchWord, int selectedIndex) {
        Connection con = JDBC_Connector.getConnection();
        movieVOList = new ArrayList<MovieVO>();
        ResultSet rs = null;
        PreparedStatement psmt = null;

        // 검색 조건에 따라 컬럼명을 배열로 관리
        String[] columnName = {"title", "genre", "director"};

        // SQL문: 검색어가 포함된 영화를 찾음
        String sql = "select * from movie where " + columnName[selectedIndex] + " like ? order by movie_id desc";

        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, "%" + searchWord + "%");
            rs = psmt.executeQuery();

            while (rs.next()) {
                MovieVO vo = new MovieVO();
                // DB 컬럼명과 1:1 매칭하여 값을 가져옴
                vo.setMovieId(rs.getInt("movie_id"));
                vo.setTitle(rs.getString("title"));
                vo.setGenre(rs.getString("genre"));
                vo.setRuntime(rs.getInt("runtime"));
                vo.setGrade(rs.getString("grade"));
                vo.setReleaseDate(rs.getDate("release_date"));
                vo.setPoster(rs.getString("poster"));
                vo.setDirector(rs.getString("director"));
                vo.setCast(rs.getString("cast"));
                vo.setEndDate(rs.getDate("end_date"));
                vo.setSynopsis(rs.getString("synopsis"));

                movieVOList.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 자원 반납
            try {
                if (rs != null) rs.close();
                if (psmt != null) psmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return movieVOList;
    }

    // 2. 영화 등록
    public void insert(MovieVO vo) {
        Connection con = JDBC_Connector.getConnection();
        // 시퀀스(seq_movie_id.nextval)를 사용하여 ID 자동 생성
        String sql = "insert into movie (movie_id, title, genre, runtime, grade, release_date, poster, director, cast, end_date, synopsis) values(seq_movie_id.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement psmt = null;

        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, vo.getTitle());
            psmt.setString(2, vo.getGenre());
            psmt.setInt(3, vo.getRuntime());
            psmt.setString(4, vo.getGrade());
            psmt.setDate(5, vo.getReleaseDate());
            psmt.setString(6, vo.getPoster());
            psmt.setString(7, vo.getDirector());
            psmt.setString(8, vo.getCast());
            psmt.setDate(9, vo.getEndDate());
            psmt.setString(10, vo.getSynopsis());

            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psmt != null) psmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("insert close 문제 발생");
                e.printStackTrace();
            }
        }
    }

    // 3. 영화 수정
    public void update(MovieVO vo) {
        Connection con = JDBC_Connector.getConnection();
        // 모든 정보를 수정할 수 있도록 설정
        String sql = "update movie set title=?, genre=?, runtime=?, grade=?, release_date=?, poster=?, director=?, cast=?, end_date=?, synopsis=? where movie_id=?";
        PreparedStatement psmt = null;

        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, vo.getTitle());
            psmt.setString(2, vo.getGenre());
            psmt.setInt(3, vo.getRuntime());
            psmt.setString(4, vo.getGrade());
            psmt.setDate(5, vo.getReleaseDate());
            psmt.setString(6, vo.getPoster());
            psmt.setString(7, vo.getDirector());
            psmt.setString(8, vo.getCast());
            psmt.setDate(9, vo.getEndDate());
            psmt.setString(10, vo.getSynopsis());
            psmt.setInt(11, vo.getMovieId()); // where 절의 movie_id

            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psmt != null) psmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("update close 문제 발생");
                e.printStackTrace();
            }
        }
    }

    // 4. 영화 삭제
    public void delete(int movieId) {
        Connection con = JDBC_Connector.getConnection();
        String sql = "delete from movie where movie_id=?";
        PreparedStatement psmt = null;

        try {
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, movieId);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psmt != null) psmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("delete close 문제 발생");
                e.printStackTrace();
            }
        }
    }
}