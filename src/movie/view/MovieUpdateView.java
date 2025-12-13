package movie.view;

import movie.domain.MovieVO;
import util.UIConstants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MovieUpdateView extends JPanel {
    // 1. 주요 컴포넌트 선언
    private JTable table;
    private DefaultTableModel model;

    // 검색 컴포넌트
    private JComboBox<String> comboSearch;
    private JTextField tfSearch;
    private JButton btnSearch;
    private String[] searchItems = {"번호", "제목", "장르", "감독"};

    // 수정 폼 패널
    private MovieFormPanel formPanel;

    // 기능 버튼
    private JButton btnUpdate, btnDelete;

    public MovieUpdateView() {
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        setBackground(UIConstants.COLOR_WHITE);

        // 2. 상단 검색 패널 구성
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        northPanel.setBackground(UIConstants.COLOR_WHITE);
        northPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        comboSearch = new JComboBox<>(searchItems);
        comboSearch.setBackground(UIConstants.COLOR_WHITE);
        comboSearch.setFont(UIConstants.FONT_INPUT);

        tfSearch = new JTextField(20);
        tfSearch.setFont(UIConstants.FONT_INPUT);

        btnSearch = new JButton("검색");
        btnSearch.setBackground(UIConstants.COLOR_BTN_GRAY);
        btnSearch.setFont(UIConstants.FONT_BTN);
        btnSearch.setFocusPainted(false);

        JLabel lblSearch = new JLabel("수정할 영화 검색 : ");
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
        UIConstants.setColumnStyle(table, 0, 40, "center");  // 번호
        UIConstants.setColumnStyle(table, 1, 150, "left");   // 제목
        UIConstants.setColumnStyle(table, 2, 70, "center");  // 장르
        UIConstants.setColumnStyle(table, 3, 80, "center");  // 감독
        UIConstants.setColumnStyle(table, 4, 120, "left");   // 출연
        UIConstants.setColumnStyle(table, 5, 80, "center");  // 등급
        UIConstants.setColumnStyle(table, 6, 50, "center");  // 시간
        UIConstants.setColumnStyle(table, 7, 90, "center");  // 개봉일
        UIConstants.setColumnStyle(table, 8, 90, "center");  // 종료일

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(UIConstants.COLOR_WHITE);
        scrollPane.setPreferredSize(new Dimension(0, 300)); // 테이블 높이 고정
        add(scrollPane, BorderLayout.CENTER);

        // 4. 하단 수정 폼 및 버튼 패널
        JPanel southContainer = new JPanel(new BorderLayout());
        southContainer.setBackground(UIConstants.COLOR_WHITE);

        // 4-1. 공통 폼 패널 조립
        formPanel = new MovieFormPanel();
        southContainer.add(formPanel, BorderLayout.CENTER);

        // 4-2. 버튼 패널
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(UIConstants.COLOR_WHITE);
        btnPanel.setBorder(new EmptyBorder(10, 0, 20, 0));

        btnUpdate = createStyledButton("정보 수정", UIConstants.COLOR_BTN_BLUE);
        btnDelete = createStyledButton("영화 삭제", UIConstants.COLOR_BTN_RED);

        btnPanel.add(btnUpdate);
        btnPanel.add(btnDelete);
        southContainer.add(btnPanel, BorderLayout.SOUTH);

        add(southContainer, BorderLayout.SOUTH);
    }

    // 버튼 스타일링 메소드
    private JButton createStyledButton(String text, Color bgColor) {
        JButton btn = new JButton(text);
        btn.setFont(UIConstants.FONT_BTN);
        btn.setBackground(bgColor);
        btn.setForeground(UIConstants.COLOR_WHITE);
        btn.setPreferredSize(new Dimension(120, 40));
        btn.setFocusPainted(false);
        return btn;
    }

    // 5. 테이블 데이터 갱신
    public void setMovieVOList(ArrayList<MovieVO> list) {
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

    // 6. 선택된 행의 데이터를 폼 패널에 전달
    public void setFieldsFromRow(MovieVO vo) {
        formPanel.setMovieVO(vo);
    }

    // 7. 수정할 데이터 반환 (Controller 사용)
    public MovieVO neededUpdateData() throws Exception {
        return formPanel.getMovieVO();
    }

    // Getter Methods
    public JTable getTable() { return table; }
    public JButton getBtnUpdate() { return btnUpdate; }
    public JButton getBtnDelete() { return btnDelete; }
    public JButton getBtnSearch() { return btnSearch; }
    public String getSearchWord() { return tfSearch.getText(); }
    public int getSelectedIndex() { return comboSearch.getSelectedIndex(); }
}