package movie.view;

import movie.domain.MovieVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;

public class MovieInsertView extends JPanel {
    // 입력 필드들
    JTextField tfTitle, tfGenre, tfRuntime, tfReleaseDate, tfPoster, tfDirector, tfCast, tfEndDate, tfSynopsis;
    JComboBox<String> comboGrade;
    JButton btnAdd;

    // 등급 목록
    String[] grades = {"전체관람가", "12세관람가", "15세관람가", "청소년관람불가"};

    public MovieInsertView() {
        setLayout(new BorderLayout());

        // 중앙 입력 패널 (GridLayout 사용)
        JPanel centerPanel = new JPanel(new GridLayout(10, 2, 5, 5)); // 10행 2열

        // 컴포넌트 초기화 및 패널 추가
        centerPanel.add(new JLabel("영화 제목:"));
        tfTitle = new JTextField();
        centerPanel.add(tfTitle);

        centerPanel.add(new JLabel("장르:"));
        tfGenre = new JTextField();
        centerPanel.add(tfGenre);

        centerPanel.add(new JLabel("러닝타임(분):"));
        tfRuntime = new JTextField();
        centerPanel.add(tfRuntime);

        centerPanel.add(new JLabel("관람 등급:"));
        comboGrade = new JComboBox<>(grades);
        centerPanel.add(comboGrade);

        centerPanel.add(new JLabel("개봉일(YYYY-MM-DD):"));
        tfReleaseDate = new JTextField();
        centerPanel.add(tfReleaseDate);

        centerPanel.add(new JLabel("포스터(URL):"));
        tfPoster = new JTextField();
        centerPanel.add(tfPoster);

        centerPanel.add(new JLabel("감독:"));
        tfDirector = new JTextField();
        centerPanel.add(tfDirector);

        centerPanel.add(new JLabel("출연진:"));
        tfCast = new JTextField();
        centerPanel.add(tfCast);

        centerPanel.add(new JLabel("종료일(YYYY-MM-DD):"));
        tfEndDate = new JTextField();
        centerPanel.add(tfEndDate);

        centerPanel.add(new JLabel("줄거리:"));
        tfSynopsis = new JTextField();
        centerPanel.add(tfSynopsis);

        add(centerPanel, BorderLayout.CENTER);

        // 하단 버튼 패널
        JPanel southPanel = new JPanel();
        btnAdd = new JButton("영화 등록");
        southPanel.add(btnAdd);
        add(southPanel, BorderLayout.SOUTH);
    }

    // 입력된 정보로 MovieVO 객체 생성 (Controller에서 호출)
    public MovieVO neededInsertData() {
        MovieVO vo = new MovieVO();
        vo.setTitle(tfTitle.getText());
        vo.setGenre(tfGenre.getText());
        // 숫자로 변환 (예외처리 생략 - 숫자만 입력해야 함)
        vo.setRuntime(Integer.parseInt(tfRuntime.getText()));
        vo.setGrade((String) comboGrade.getSelectedItem());
        // 날짜 변환 (YYYY-MM-DD 형식을 지켜야 함)
        vo.setReleaseDate(Date.valueOf(tfReleaseDate.getText()));
        vo.setPoster(tfPoster.getText());
        vo.setDirector(tfDirector.getText());
        vo.setCast(tfCast.getText());
        vo.setEndDate(Date.valueOf(tfEndDate.getText()));
        vo.setSynopsis(tfSynopsis.getText());

        return vo;
    }

    // 입력창 초기화
    public void initInsertData() {
        tfTitle.setText("");
        tfGenre.setText("");
        tfRuntime.setText("");
        comboGrade.setSelectedIndex(0);
        tfReleaseDate.setText("");
        tfPoster.setText("");
        tfDirector.setText("");
        tfCast.setText("");
        tfEndDate.setText("");
        tfSynopsis.setText("");
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }
}