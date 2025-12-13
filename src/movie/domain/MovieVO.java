package movie.domain;

import java.sql.Date;

public class MovieVO {
    // 1. DB 테이블 컬럼과 1:1 매칭되는 변수 (총 11개)
    private int movieId;        // movie_id (숫자)
    private String title;       // title (제목)
    private String genre;       // genre (장르)
    private int runtime;        // runtime (상영시간)
    private String grade;       // grade (관람등급)
    private Date releaseDate;   // release_date (개봉일)
    private String poster;      // poster (포스터 URL 문자열)
    private String director;    // director (감독)
    private String cast;        // cast (출연진)
    private Date endDate;       // end_date (상영종료일)
    private String synopsis;    // synopsis (줄거리)

    // 2. 기본 생성자
    public MovieVO() {
    }

    // 3. 모든 필드를 초기화하는 생성자
    public MovieVO(int movieId, String title, String genre, int runtime, String grade,
                   Date releaseDate, String poster, String director, String cast,
                   Date endDate, String synopsis) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.runtime = runtime;
        this.grade = grade;
        this.releaseDate = releaseDate;
        this.poster = poster;
        this.director = director;
        this.cast = cast;
        this.endDate = endDate;
        this.synopsis = synopsis;
    }

    // 4. Getter & Setter 메소드
    public int getMovieId() { return movieId; }
    public void setMovieId(int movieId) { this.movieId = movieId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getRuntime() { return runtime; }
    public void setRuntime(int runtime) { this.runtime = runtime; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public Date getReleaseDate() { return releaseDate; }
    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }

    public String getPoster() { return poster; }
    public void setPoster(String poster) { this.poster = poster; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getCast() { return cast; }
    public void setCast(String cast) { this.cast = cast; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public String getSynopsis() { return synopsis; }
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }
}