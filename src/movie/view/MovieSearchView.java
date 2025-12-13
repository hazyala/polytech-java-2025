package movie.view;

import movie.domain.MovieVO;
import util.UIConstants;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

public class MovieSearchView extends JPanel {
    // 1. 주요 컴포넌트 선언
    private JTable table;
    private DefaultTableModel model;
    private ArrayList<MovieVO> movieVOList;

    // 검색 관련 컴포넌트
    private JComboBox<String> comboSearch;
    private JTextField tfSearch;
    private JButton btnSearch;
    private String[] searchItems = {"번호", "제목", "장르", "감독"};

    // 상세 정보 패널 (포스터 + 줄거리)
    private JLabel lblPoster;
    private JTextArea taSynopsis;

    public MovieSearchView() {
        initUI();
    }

    //* 생성자 코드를 분리하여 화면 초기화 로직을 별도로 관리하도록 하였습니다.
    private void initUI() {
        setLayout(new BorderLayout());
        setBackground(UIConstants.COLOR_WHITE);

        // 2. 상단 검색 패널 구성
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        northPanel.setBackground(UIConstants.COLOR_WHITE);

        comboSearch = new JComboBox<>(searchItems);
        comboSearch.setBackground(UIConstants.COLOR_WHITE);
        comboSearch.setFont(UIConstants.FONT_INPUT);

        tfSearch = new JTextField(20);
        tfSearch.setFont(UIConstants.FONT_INPUT);

        btnSearch = new JButton("검색");
        btnSearch.setBackground(UIConstants.COLOR_BTN_GRAY); //* UIConstants 색상 적용
        btnSearch.setFont(UIConstants.FONT_BTN);
        btnSearch.setFocusPainted(false);

        JLabel lblSearch = new JLabel("검색조건:");
        lblSearch.setFont(UIConstants.FONT_LABEL);

        northPanel.add(lblSearch);
        northPanel.add(comboSearch);
        northPanel.add(tfSearch);
        northPanel.add(btnSearch);
        add(northPanel, BorderLayout.NORTH);

        // 3. 중앙 테이블 구성
        String[] header = {"번호", "제목", "장르", "감독", "출연", "등급", "시간", "개봉일", "종료일"};
        model = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        table = new JTable(model);

        UIConstants.setTableStyle(table);
        UIConstants.setColumnStyle(table, 0, 40, "center");
        UIConstants.setColumnStyle(table, 1, 150, "left");
        UIConstants.setColumnStyle(table, 2, 70, "center");
        UIConstants.setColumnStyle(table, 3, 80, "center");
        UIConstants.setColumnStyle(table, 4, 120, "left");
        UIConstants.setColumnStyle(table, 5, 80, "center");
        UIConstants.setColumnStyle(table, 6, 50, "center");
        UIConstants.setColumnStyle(table, 7, 90, "center");
        UIConstants.setColumnStyle(table, 8, 90, "center");

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(UIConstants.COLOR_WHITE);
        add(scrollPane, BorderLayout.CENTER);

        // 4. 우측 상세 정보 패널 구성
        JPanel eastPanel = new JPanel(new BorderLayout(5, 5));
        eastPanel.setBackground(UIConstants.COLOR_WHITE);
        eastPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        eastPanel.setPreferredSize(new Dimension(300, 0));

        // 4-1. 포스터 영역
        lblPoster = new JLabel("포스터 미리보기", JLabel.CENTER);
        lblPoster.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        lblPoster.setFont(UIConstants.FONT_LABEL);
        eastPanel.add(lblPoster, BorderLayout.CENTER);

        // 4-2. 줄거리 영역
        JPanel synopsisPanel = new JPanel(new BorderLayout());
        synopsisPanel.setBackground(UIConstants.COLOR_WHITE);
        synopsisPanel.setBorder(BorderFactory.createTitledBorder(null, "줄거리", 0, 0, UIConstants.FONT_LABEL));
        synopsisPanel.setPreferredSize(new Dimension(0, 200));

        taSynopsis = new JTextArea();
        taSynopsis.setLineWrap(true);
        taSynopsis.setWrapStyleWord(true);
        taSynopsis.setEditable(false);
        taSynopsis.setFont(UIConstants.FONT_INPUT);
        JScrollPane txtScroll = new JScrollPane(taSynopsis);
        txtScroll.setBorder(null);

        synopsisPanel.add(txtScroll, BorderLayout.CENTER);
        eastPanel.add(synopsisPanel, BorderLayout.SOUTH);

        add(eastPanel, BorderLayout.EAST);
    }

    // 5. 테이블 데이터 갱신
    public void setMovieVOList(ArrayList<MovieVO> list) {
        this.movieVOList = list;
        model.setRowCount(0);
        for (MovieVO vo : list) {
            Object[] row = {
                    vo.getMovieId(), vo.getTitle(), vo.getGenre(),
                    vo.getDirector(), vo.getCast(), vo.getGrade(),
                    vo.getRuntime(), vo.getReleaseDate(), vo.getEndDate()
            };
            model.addRow(row);
        }
    }

    // 6. 상세 정보 표시 (테이블 클릭 시 호출)
    public void setDetailInfo(MovieVO vo) {
        try {
            URL url = new URL(vo.getPoster());
            ImageIcon icon = new ImageIcon(url);
            Image img = icon.getImage().getScaledInstance(280, 350, Image.SCALE_SMOOTH);
            lblPoster.setIcon(new ImageIcon(img));
            lblPoster.setText("");
        } catch (Exception e) {
            lblPoster.setIcon(null);
            lblPoster.setText("이미지 없음");
        }
        taSynopsis.setText(vo.getSynopsis());
        taSynopsis.setCaretPosition(0);
    }

    // Getter Methods
    public JButton getBtnSearch() { return btnSearch; }
    public String getSearchWord() { return tfSearch.getText(); }
    public int getSelectedIndex() { return comboSearch.getSelectedIndex(); }
    public JTable getTable() { return table; }
}