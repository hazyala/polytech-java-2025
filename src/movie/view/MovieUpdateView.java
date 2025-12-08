package movie.view;

import movie.domain.MovieVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;

public class MovieUpdateView extends JPanel {
    JTable table;
    DefaultTableModel model;
    ArrayList<MovieVO> movieVOList;
    String[] header = {"번호", "제목", "장르", "감독", "등급"}; // 간단히 표시

    // 수정 입력 필드
    JTextField tfId, tfTitle, tfGenre, tfRuntime, tfReleaseDate, tfPoster, tfDirector, tfCast, tfEndDate, tfSynopsis;
    JComboBox<String> comboGrade;
    String[] grades = {"전체관람가", "12세관람가", "15세관람가", "청소년관람불가"};

    JButton btnUpdate, btnDelete;

    public MovieUpdateView() {
        setLayout(new BorderLayout());

        // 1. 중앙 테이블
        model = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // 2. 하단 수정 패널 (입력창 + 버튼)
        JPanel southPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(6, 4)); // 입력창들

        inputPanel.add(new JLabel("번호(수정불가):"));
        tfId = new JTextField(); tfId.setEditable(false);
        inputPanel.add(tfId);

        inputPanel.add(new JLabel("제목:"));
        tfTitle = new JTextField();
        inputPanel.add(tfTitle);

        inputPanel.add(new JLabel("장르:"));
        tfGenre = new JTextField();
        inputPanel.add(tfGenre);

        inputPanel.add(new JLabel("감독:"));
        tfDirector = new JTextField();
        inputPanel.add(tfDirector);

        inputPanel.add(new JLabel("등급:"));
        comboGrade = new JComboBox<>(grades);
        inputPanel.add(comboGrade);

        inputPanel.add(new JLabel("시간(분):"));
        tfRuntime = new JTextField();
        inputPanel.add(tfRuntime);

        inputPanel.add(new JLabel("개봉일:"));
        tfReleaseDate = new JTextField();
        inputPanel.add(tfReleaseDate);

        inputPanel.add(new JLabel("종료일:"));
        tfEndDate = new JTextField();
        inputPanel.add(tfEndDate);

        inputPanel.add(new JLabel("출연:"));
        tfCast = new JTextField();
        inputPanel.add(tfCast);

        inputPanel.add(new JLabel("포스터URL:"));
        tfPoster = new JTextField();
        inputPanel.add(tfPoster);

        inputPanel.add(new JLabel("줄거리:"));
        tfSynopsis = new JTextField();
        inputPanel.add(tfSynopsis);

        southPanel.add(inputPanel, BorderLayout.CENTER);

        // 버튼
        JPanel btnPanel = new JPanel();
        btnUpdate = new JButton("정보 수정");
        btnDelete = new JButton("영화 삭제");
        btnPanel.add(btnUpdate);
        btnPanel.add(btnDelete);
        southPanel.add(btnPanel, BorderLayout.SOUTH);

        add(southPanel, BorderLayout.SOUTH);
    }

    public void setMovieVOList(ArrayList<MovieVO> list) {
        this.movieVOList = list;
        model.setRowCount(0);
        for (MovieVO vo : list) {
            Object[] row = { vo.getMovieId(), vo.getTitle(), vo.getGenre(), vo.getDirector(), vo.getGrade() };
            model.addRow(row);
        }
    }

    // 테이블 선택 시 입력창 채우기
    public void setFieldsFromRow(int rowIndex) {
        MovieVO vo = movieVOList.get(rowIndex);
        tfId.setText(String.valueOf(vo.getMovieId()));
        tfTitle.setText(vo.getTitle());
        tfGenre.setText(vo.getGenre());
        tfDirector.setText(vo.getDirector());
        comboGrade.setSelectedItem(vo.getGrade());
        tfRuntime.setText(String.valueOf(vo.getRuntime()));
        tfReleaseDate.setText(String.valueOf(vo.getReleaseDate()));
        tfEndDate.setText(String.valueOf(vo.getEndDate()));
        tfCast.setText(vo.getCast());
        tfPoster.setText(vo.getPoster());
        tfSynopsis.setText(vo.getSynopsis());
    }

    // 수정 데이터 가져오기
    public MovieVO neededUpdateData() {
        MovieVO vo = new MovieVO();
        vo.setMovieId(Integer.parseInt(tfId.getText()));
        vo.setTitle(tfTitle.getText());
        vo.setGenre(tfGenre.getText());
        vo.setDirector(tfDirector.getText());
        vo.setGrade((String)comboGrade.getSelectedItem());
        vo.setRuntime(Integer.parseInt(tfRuntime.getText()));
        vo.setReleaseDate(Date.valueOf(tfReleaseDate.getText()));
        vo.setEndDate(Date.valueOf(tfEndDate.getText()));
        vo.setCast(tfCast.getText());
        vo.setPoster(tfPoster.getText());
        vo.setSynopsis(tfSynopsis.getText());
        return vo;
    }

    public JTable getTable() { return table; }
    public JButton getBtnUpdate() { return btnUpdate; }
    public JButton getBtnDelete() { return btnDelete; }
}