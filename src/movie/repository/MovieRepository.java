package movie.repository;

import movie.domain.MovieVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieRepository {

    // 1. 영화 목록 조회 및 검색
    public ArrayList<MovieVO> select(String searchWord, int selectedIndex) {
        ArrayList<MovieVO> list = new ArrayList<>();
        Connection con = JDBC_Connector.getConnection();
        PreparedStatement psmt = null;
        ResultSet rs = null;

        //* 수업에서는 if-else문으로 검색 조건을 분기했으나, 배열을 활용하여 코드를 간결하게 최적화하였습니다.
        String[] columnName = {"movie_id", "title", "genre", "director"};

        String sql = "select * from movie where " + columnName[selectedIndex] + " like ? order by movie_id desc";

        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, "%" + searchWord + "%");
            rs = psmt.executeQuery();

            while (rs.next()) {
                MovieVO vo = new MovieVO();
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

                list.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //* 수업에서는 매번 try-catch로 닫았으나, JDBC_Connector에 통합 close 메소드를 만들어 코드를 간소화했습니다.
            JDBC_Connector.close(rs, psmt, con);
        }
        return list;
    }

    // 2. 영화 등록
    public void insert(MovieVO vo) {
        Connection con = JDBC_Connector.getConnection();
        PreparedStatement psmt = null;

        // 시퀀스(seq_movie_id)를 사용하여 자동 증가
        String sql = "insert into movie (movie_id, title, genre, runtime, grade, release_date, poster, director, cast, end_date, synopsis) " +
                "values(seq_movie_id.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            JDBC_Connector.close(null, psmt, con);
        }
    }

    // 3. 영화 수정
    public void update(MovieVO vo) {
        Connection con = JDBC_Connector.getConnection();
        PreparedStatement psmt = null;

        String sql = "update movie set title=?, genre=?, runtime=?, grade=?, release_date=?, poster=?, director=?, cast=?, end_date=?, synopsis=? where movie_id=?";

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
            psmt.setInt(11, vo.getMovieId());

            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Connector.close(null, psmt, con);
        }
    }

    // 4. 영화 삭제
    public void delete(int movieId) {
        Connection con = JDBC_Connector.getConnection();
        PreparedStatement psmt = null;

        String sql = "delete from movie where movie_id=?";

        try {
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, movieId);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Connector.close(null, psmt, con);
        }
    }
}