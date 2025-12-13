package movie.view;

import movie.domain.MovieVO;
import util.UIConstants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MovieInsertView extends JPanel {
    // 1. 주요 컴포넌트 선언
    MovieFormPanel formPanel;
    JButton btnAdd;

    public MovieInsertView() {
        initUI();
    }

    //* 생성자 코드를 분리하여 화면 초기화 로직을 별도로 관리하도록 하였습니다.
    private void initUI() {
        setLayout(new BorderLayout());
        setBackground(UIConstants.COLOR_WHITE);

        // 2. 상단 제목 패널 구성
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(UIConstants.COLOR_WHITE);
        titlePanel.setBorder(new EmptyBorder(20, 0, 20, 0));

        JLabel lblHeader = new JLabel("영화 등록");
        lblHeader.setFont(UIConstants.FONT_TITLE); //* UIConstants 폰트 적용
        titlePanel.add(lblHeader);
        add(titlePanel, BorderLayout.NORTH);

        // 3. 중앙 폼 패널 (공통 부품 조립)
        //* MovieFormPanel을 재사용하여 등록 화면을 구성하였습니다.
        formPanel = new MovieFormPanel();
        add(formPanel, BorderLayout.CENTER);

        // 4. 하단 버튼 패널 구성
        JPanel southPanel = new JPanel();
        southPanel.setBackground(UIConstants.COLOR_WHITE);
        southPanel.setBorder(new EmptyBorder(20, 0, 20, 0));

        btnAdd = new JButton("영화 등록");
        btnAdd.setFont(UIConstants.FONT_BTN);           //* UIConstants 폰트 적용
        btnAdd.setBackground(UIConstants.COLOR_BTN_BLUE); //* UIConstants 색상 적용
        btnAdd.setForeground(UIConstants.COLOR_WHITE);
        btnAdd.setPreferredSize(new Dimension(200, 50));
        btnAdd.setFocusPainted(false);

        southPanel.add(btnAdd);
        add(southPanel, BorderLayout.SOUTH);
    }

    // 5. 입력 데이터 반환 (Controller 사용)
    public MovieVO neededInsertData() throws Exception {
        return formPanel.getMovieVO();
    }

    // 6. 입력창 초기화
    public void initInsertData() {
        formPanel.clearFields();
    }

    public JButton getBtnAdd() { return btnAdd; }
}