package movie.view;

import movie.domain.MovieVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

public class MovieSearchView extends JPanel {
    JTable table;
    DefaultTableModel model;
    ArrayList<MovieVO> movieVOList;
    // 헤더: 번호, 제목, 장르, 감독, 등급, 시간, 개봉일 (포스터 등은 공간상 생략)
    String[] header = {"번호", "제목", "장르", "감독", "등급", "시간", "개봉일"};

    // 검색 관련 컴포넌트
    JComboBox<String> comboSearch;
    JTextField tfSearch;
    JButton btnSearch;
    String[] searchItems = {"제목", "장르", "감독"};

    // 포스터 이미지 표시용 라벨
    JLabel lblPoster;

    public MovieSearchView() {
        setLayout(new BorderLayout());

        // 1. 상단 검색 패널
        JPanel northPanel = new JPanel();
        comboSearch = new JComboBox<>(searchItems);
        tfSearch = new JTextField(20);
        btnSearch = new JButton("검색");

        northPanel.add(new JLabel("검색조건:"));
        northPanel.add(comboSearch);
        northPanel.add(tfSearch);
        northPanel.add(btnSearch);
        add(northPanel, BorderLayout.NORTH);

        // 2. 중앙 테이블 (스크롤)
        model = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 수정 불가
            }
        };
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // 3. 우측 포스터 패널 (이미지)
        JPanel eastPanel = new JPanel(new BorderLayout());
        lblPoster = new JLabel("포스터 이미지", JLabel.CENTER);
        lblPoster.setPreferredSize(new Dimension(300, 400)); // 포스터 크기 지정
        lblPoster.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        eastPanel.add(lblPoster, BorderLayout.CENTER);
        add(eastPanel, BorderLayout.EAST);
    }

    // 테이블에 데이터 채우기
    public void setMovieVOList(ArrayList<MovieVO> list) {
        this.movieVOList = list;
        model.setRowCount(0); // 기존 데이터 삭제
        for (MovieVO vo : list) {
            Object[] row = {
                    vo.getMovieId(),
                    vo.getTitle(),
                    vo.getGenre(),
                    vo.getDirector(),
                    vo.getGrade(),
                    vo.getRuntime(),
                    vo.getReleaseDate()
            };
            model.addRow(row);
        }
    }

    // 포스터 이미지 보여주기 (URL 사용)
    public void setPosterImage(String urlString) {
        try {
            URL url = new URL(urlString);
            ImageIcon icon = new ImageIcon(url);

            // 이미지 크기 조절 (JLabel 크기에 맞게)
            Image img = icon.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
            lblPoster.setIcon(new ImageIcon(img));
            lblPoster.setText("");
        } catch (Exception e) {
            lblPoster.setIcon(null);
            lblPoster.setText("이미지 없음");
        }
    }

    // Getter
    public JButton getBtnSearch() { return btnSearch; }
    public String getSearchWord() { return tfSearch.getText(); }
    public int getSelectedIndex() { return comboSearch.getSelectedIndex(); }
    public JTable getTable() { return table; }
}