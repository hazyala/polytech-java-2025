package movie.view;

import center_frame.CenterFrame;
import javax.swing.*;

public class MovieMainFrame extends JFrame {
    // 탭 패널
    JTabbedPane tab = new JTabbedPane();

    // 각 뷰 인스턴스
    MovieInsertView insertView = new MovieInsertView();
    MovieSearchView searchView = new MovieSearchView();
    MovieUpdateView updateView = new MovieUpdateView();

    public MovieMainFrame() {
        setTitle("무비 스나이퍼 (관리자 모드)");

        // 탭 추가
        tab.add("영화 목록/검색", searchView);
        tab.add("영화 등록", insertView);
        tab.add("영화 수정/삭제", updateView);

        add(tab);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // CenterFrame 활용
        CenterFrame cf = new CenterFrame(1000, 700);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    // Controller에서 뷰를 쓸 수 있게 Getter 제공
    public MovieInsertView getInsertView() { return insertView; }
    public MovieSearchView getSearchView() { return searchView; }
    public MovieUpdateView getUpdateView() { return updateView; }
    public JTabbedPane getTab() { return tab; }
}