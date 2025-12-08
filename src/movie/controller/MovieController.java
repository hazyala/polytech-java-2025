package movie.controller;

import movie.domain.MovieVO;
import movie.repository.MovieRepository;
import movie.view.MovieInsertView;
import movie.view.MovieMainFrame;
import movie.view.MovieSearchView;
import movie.view.MovieUpdateView;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MovieController {
    // 1. 필요한 부품들을 선언
    MovieRepository repository;
    MovieMainFrame mainFrame;
    MovieInsertView insertView;
    MovieSearchView searchView;
    MovieUpdateView updateView;

    ArrayList<MovieVO> list;

    public MovieController() {
        // 2. 부품 조립
        repository = new MovieRepository();
        mainFrame = new MovieMainFrame();

        // 메인 프레임에서 뷰들을 가져옴
        insertView = mainFrame.getInsertView();
        searchView = mainFrame.getSearchView();
        updateView = mainFrame.getUpdateView();

        // 3. 초기 데이터 로드 (프로그램 켜자마자 목록 보여주기)
        refreshAllViews();

        // 4. 이벤트 연결 (버튼 누르면 동작하게 하기)
        // [검색 탭] 검색 버튼
        searchView.getBtnSearch().addActionListener(btnSearchL);
        // [검색 탭] 테이블 클릭 (포스터 로드)
        searchView.getTable().addMouseListener(tableSearchL);

        // [등록 탭] 등록 버튼
        insertView.getBtnAdd().addActionListener(btnInsertL);

        // [수정 탭] 수정/삭제 버튼
        updateView.getBtnUpdate().addActionListener(btnUpdateL);
        updateView.getBtnDelete().addActionListener(btnDeleteL);
        // [수정 탭] 테이블 클릭 (입력창 채우기)
        updateView.getTable().addMouseListener(tableUpdateL);

        // [탭 변경] 탭 바꿀 때마다 데이터 새로고침
        mainFrame.getTab().addChangeListener(tabL);
    }

    // --- [리스너(Listener) 정의] ---

    // 1. 검색 버튼 리스너
    ActionListener btnSearchL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String word = searchView.getSearchWord();
            int index = searchView.getSelectedIndex();
            list = repository.select(word, index);
            searchView.setMovieVOList(list);
        }
    };

    // 2. 검색 탭 테이블 클릭 리스너
    MouseAdapter tableSearchL = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = searchView.getTable().getSelectedRow();
            // 현재 리스트에서 해당 행의 영화 정보를 가져옴
            MovieVO vo = list.get(row);
            // 뷰에게 포스터 링크를 주며 그려달라고 요청
            searchView.setPosterImage(vo.getPoster());
        }
    };

    // 3. 영화 등록 버튼 리스너
    ActionListener btnInsertL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                MovieVO vo = insertView.neededInsertData();
                repository.insert(vo);
                JOptionPane.showMessageDialog(mainFrame, "영화가 성공적으로 등록되었습니다.");
                insertView.initInsertData(); // 입력창 초기화
                refreshAllViews(); // 목록 갱신
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainFrame, "입력 정보를 확인해주세요. (숫자/날짜 형식 등)");
            }
        }
    };

    // 4. 영화 수정 버튼 리스너
    ActionListener btnUpdateL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                MovieVO vo = updateView.neededUpdateData();
                repository.update(vo);
                JOptionPane.showMessageDialog(mainFrame, "영화 정보가 수정되었습니다.");
                refreshAllViews();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainFrame, "수정 실패. 입력값을 확인하세요.");
            }
        }
    };

    // 5. 영화 삭제 버튼 리스너
    ActionListener btnDeleteL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int row = updateView.getTable().getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(mainFrame, "삭제할 영화를 선택해주세요.");
                return;
            }

            int answer = JOptionPane.showConfirmDialog(mainFrame, "정말로 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                // 현재 입력창에 있는 ID를 기준으로 삭제 (테이블 클릭 시 채워짐)
                try {
                    MovieVO vo = updateView.neededUpdateData();
                    repository.delete(vo.getMovieId());
                    refreshAllViews();
                    // 수정 뷰 입력창 초기화는 선택사항
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mainFrame, "삭제 중 오류가 발생했습니다.");
                }
            }
        }
    };

    // 6. 수정 탭 테이블 클릭 리스너 (클릭하면 입력창에 정보 쏙!)
    MouseAdapter tableUpdateL = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = updateView.getTable().getSelectedRow();
            updateView.setFieldsFromRow(row);
        }
    };

    // 7. 탭 변경 리스너 (탭 누를 때마다 최신 목록 불러오기)
    ChangeListener tabL = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            refreshAllViews();
        }
    };

    // [공통 기능] 모든 뷰의 데이터를 최신으로 갱신
    public void refreshAllViews() {
        list = repository.select("", 0); // 전체 목록 조회
        searchView.setMovieVOList(list); // 검색 탭 갱신
        updateView.setMovieVOList(list); // 수정 탭 갱신
        // 등록 탭은 목록 테이블이 없으므로 생략
    }

    // ★ 프로그램 시작점 ★
    public static void main(String[] args) {
        new MovieController();
    }
}