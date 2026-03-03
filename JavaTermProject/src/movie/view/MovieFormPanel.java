package movie.view;

import movie.domain.MovieVO;
import util.UIConstants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Date;

public class MovieFormPanel extends JPanel {
    // 1. 입력 컴포넌트 선언 (DB 컬럼과 매칭)
    private JTextField tfTitle;       // title (제목)
    private JTextField tfDirector;    // director (감독)
    private JTextField tfCast;        // cast (출연진)
    private JTextField tfGenre;       // genre (장르)
    private JTextField tfRuntime;     // runtime (상영시간)
    private JTextField tfReleaseDate; // release_date (개봉일)
    private JTextField tfEndDate;     // end_date (종료일)
    private JTextField tfPoster;      // poster (포스터 URL)
    private JTextArea taSynopsis;     // synopsis (줄거리)
    private JComboBox<String> comboGrade; // grade (관람등급)

    // 수정 시에만 사용되는 숨겨진 ID (등록 시에는 0)
    private int hiddenMovieId = 0;

    String[] grades = {"전체관람가", "12세관람가", "15세관람가", "청소년관람불가"};

    public MovieFormPanel() {
        initUI();
    }

    //* 수업에서는 생성자에 모든 UI 코드를 작성했으나, 가독성과 유지보수를 위해 initUI() 메소드로 분리하여 정리하였습니다.
    private void initUI() {
        setLayout(new GridBagLayout());
        setBackground(UIConstants.COLOR_WHITE); //* UIConstants 상수 사용
        setBorder(new EmptyBorder(20, 50, 0, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // 컴포넌트 생성 및 스타일 적용
        tfTitle = createTextField();
        tfDirector = createTextField();
        tfCast = createTextField();
        tfGenre = createTextField();
        tfRuntime = createTextField();
        tfReleaseDate = createTextField();
        tfEndDate = createTextField();
        tfPoster = createTextField();

        comboGrade = new JComboBox<>(grades);
        comboGrade.setBackground(UIConstants.COLOR_WHITE);
        comboGrade.setFont(UIConstants.FONT_INPUT);

        taSynopsis = new JTextArea(3, 10);
        taSynopsis.setLineWrap(true);
        taSynopsis.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        taSynopsis.setFont(UIConstants.FONT_INPUT);
        JScrollPane scrollSynopsis = new JScrollPane(taSynopsis);

        // 화면 배치
        // 1행: 제목
        addLabel("제목", 0, 0, gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.gridwidth = 3;
        add(tfTitle, gbc);
        gbc.gridwidth = 1;

        // 2행: 감독 / 출연
        addLabel("감독", 0, 1, gbc);
        gbc.gridx = 1; gbc.gridy = 1; add(tfDirector, gbc);
        addLabel("출연", 2, 1, gbc);
        gbc.gridx = 3; gbc.gridy = 1; add(tfCast, gbc);

        // 3행: 장르 / 등급
        addLabel("장르", 0, 2, gbc);
        gbc.gridx = 1; gbc.gridy = 2; add(tfGenre, gbc);
        addLabel("등급", 2, 2, gbc);
        gbc.gridx = 3; gbc.gridy = 2; add(comboGrade, gbc);

        // 4행: 시간 / 개봉일
        addLabel("시간(분)", 0, 3, gbc);
        gbc.gridx = 1; gbc.gridy = 3; add(tfRuntime, gbc);
        addLabel("개봉일", 2, 3, gbc);
        gbc.gridx = 3; gbc.gridy = 3; add(tfReleaseDate, gbc);

        // 5행: 종료일 / 포스터
        addLabel("종료일", 0, 4, gbc);
        gbc.gridx = 1; gbc.gridy = 4; add(tfEndDate, gbc);
        addLabel("포스터URL", 2, 4, gbc);
        gbc.gridx = 3; gbc.gridy = 4; add(tfPoster, gbc);

        // 6행: 줄거리
        addLabel("줄거리", 0, 5, gbc);
        gbc.gridx = 1; gbc.gridy = 5; gbc.gridwidth = 3; gbc.weighty = 1.0; gbc.fill = GridBagConstraints.BOTH;
        add(scrollSynopsis, gbc);
    }

    // 2. 입력 데이터 추출 및 유효성 검사 (Controller에서 호출)
    public MovieVO getMovieVO() throws Exception {
        // 2-1. 빈값 체크
        if (tfTitle.getText().trim().isEmpty()) throw new Exception("영화 제목을 입력해주세요.");
        if (tfDirector.getText().trim().isEmpty()) throw new Exception("감독 이름을 입력해주세요.");
        if (tfCast.getText().trim().isEmpty()) throw new Exception("출연진을 입력해주세요.");
        if (tfGenre.getText().trim().isEmpty()) throw new Exception("장르를 입력해주세요.");
        if (tfRuntime.getText().trim().isEmpty()) throw new Exception("러닝타임을 입력해주세요.");
        if (tfReleaseDate.getText().trim().isEmpty()) throw new Exception("개봉일을 입력해주세요.");
        if (tfEndDate.getText().trim().isEmpty()) throw new Exception("종료일을 입력해주세요.");

        MovieVO vo = new MovieVO();
        vo.setMovieId(this.hiddenMovieId);
        vo.setTitle(tfTitle.getText());
        vo.setGenre(tfGenre.getText());

        // 2-2. 숫자 변환 체크
        try {
            vo.setRuntime(Integer.parseInt(tfRuntime.getText()));
        } catch (NumberFormatException e) {
            throw new Exception("러닝타임은 '숫자'로만 입력해주세요.");
        }

        // 2-3. 날짜 변환 체크
        try {
            vo.setGrade((String)comboGrade.getSelectedItem());
            vo.setReleaseDate(Date.valueOf(tfReleaseDate.getText()));
            vo.setEndDate(Date.valueOf(tfEndDate.getText()));
        } catch (IllegalArgumentException e) {
            //* 수업에서는 포맷 검사를 생략하는 경우가 많았으나, 데이터 무결성을 위해 예외 처리를 작성하였습니다.
            throw new Exception("날짜는 'YYYY-MM-DD' 형식으로 입력해주세요.");
        }

        vo.setCast(tfCast.getText());
        vo.setDirector(tfDirector.getText());
        vo.setPoster(tfPoster.getText());
        vo.setSynopsis(taSynopsis.getText());

        return vo;
    }

    // 3. 폼에 데이터 채우기 (수정 모드 시 호출)
    public void setMovieVO(MovieVO vo) {
        this.hiddenMovieId = vo.getMovieId();
        tfTitle.setText(vo.getTitle());
        tfGenre.setText(vo.getGenre());
        tfDirector.setText(vo.getDirector());
        comboGrade.setSelectedItem(vo.getGrade());
        tfRuntime.setText(String.valueOf(vo.getRuntime()));
        tfReleaseDate.setText(String.valueOf(vo.getReleaseDate()));
        tfEndDate.setText(String.valueOf(vo.getEndDate()));
        tfCast.setText(vo.getCast());
        tfPoster.setText(vo.getPoster());
        taSynopsis.setText(vo.getSynopsis());
        taSynopsis.setCaretPosition(0);
    }

    // 4. 입력 필드 초기화
    public void clearFields() {
        this.hiddenMovieId = 0;
        tfTitle.setText("");
        tfGenre.setText("");
        tfDirector.setText("");
        tfCast.setText("");
        tfRuntime.setText("");
        tfReleaseDate.setText("");
        tfEndDate.setText("");
        tfPoster.setText("");
        taSynopsis.setText("");
        comboGrade.setSelectedIndex(0);
    }

    // 텍스트필드 생성
    private JTextField createTextField() {
        JTextField tf = new JTextField();
        tf.setFont(UIConstants.FONT_INPUT); //* UIConstants 사용
        return tf;
    }

    // 라벨 추가
    private void addLabel(String text, int x, int y, GridBagConstraints gbc) {
        gbc.gridx = x; gbc.gridy = y;
        double originalWeight = gbc.weightx;
        int originalFill = gbc.fill;
        gbc.weightx = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;

        JLabel label = new JLabel(text);
        label.setFont(UIConstants.FONT_LABEL); //* UIConstants 사용
        add(label, gbc);

        // 설정 원복
        gbc.weightx = originalWeight;
        gbc.fill = originalFill;
    }
}