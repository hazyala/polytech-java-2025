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
    // 1. Repository, View 선언
    MovieRepository repository;
    MovieMainFrame mainFrame;
    MovieInsertView insertView;
    MovieSearchView searchView;
    MovieUpdateView updateView;

    ArrayList<MovieVO> list;

    public MovieController() {
        // 2. 객체 생성 및 뷰 연결
        repository = new MovieRepository();
        mainFrame = new MovieMainFrame();

        insertView = mainFrame.getInsertView();
        searchView = mainFrame.getSearchView();
        updateView = mainFrame.getUpdateView();

        // 3. 초기 데이터 로드 (전체 목록 갱신)
        refreshAllViews();

        // 4. 이벤트 리스너 등록
        eventRegister();
    }

    public void eventRegister() {
        // 검색 탭
        searchView.getBtnSearch().addActionListener(btnSearchL);
        searchView.getTable().addMouseListener(tableSearchL);

        // 등록 탭
        insertView.getBtnAdd().addActionListener(btnInsertL);

        // 수정/삭제 탭
        updateView.getBtnUpdate().addActionListener(btnUpdateL);
        updateView.getBtnDelete().addActionListener(btnDeleteL);
        updateView.getBtnSearch().addActionListener(btnUpdateSearchL);
        updateView.getTable().addMouseListener(tableUpdateL);

        // 탭 변경
        mainFrame.getTab().addChangeListener(tabL);
    }

    // 5. 공통 기능: 모든 뷰 데이터 새로고침
    public void refreshAllViews() {
        list = repository.select("", 0);
        searchView.setMovieVOList(list);
        updateView.setMovieVOList(list);
    }

    // ====================================
    // 리스너 (Listener)
    // ====================================

    // 6. 검색 버튼 리스너
    ActionListener btnSearchL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String word = searchView.getSearchWord();
            int index = searchView.getSelectedIndex();
            list = repository.select(word, index);
            searchView.setMovieVOList(list);
        }
    };

    // 7. 검색 탭 테이블 클릭 리스너
    MouseAdapter tableSearchL = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = searchView.getTable().getSelectedRow();
            MovieVO vo = list.get(row);
            searchView.setDetailInfo(vo);
        }
    };

    // 8. 영화 등록 버튼 리스너
    ActionListener btnInsertL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                MovieVO vo = insertView.neededInsertData();
                repository.insert(vo);
                //* 아이콘 없이 깔끔한 메시지 출력 (PLAIN_MESSAGE 사용)
                JOptionPane.showMessageDialog(mainFrame, "영화가 성공적으로 등록되었습니다.", "알림", JOptionPane.PLAIN_MESSAGE);
                insertView.initInsertData();
                refreshAllViews();
            } catch (Exception ex) {
                //* 에러 아이콘 대신 텍스트만 출력
                JOptionPane.showMessageDialog(mainFrame, ex.getMessage(), "입력 오류", JOptionPane.PLAIN_MESSAGE);
            }
        }
    };

    // 9. 영화 수정 버튼 리스너
    ActionListener btnUpdateL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                MovieVO vo = updateView.neededUpdateData();
                repository.update(vo);
                JOptionPane.showMessageDialog(mainFrame, "영화 정보가 수정되었습니다.", "알림", JOptionPane.PLAIN_MESSAGE);
                refreshAllViews();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainFrame, ex.getMessage(), "수정 오류", JOptionPane.PLAIN_MESSAGE);
            }
        }
    };

    // 10. 영화 삭제 버튼 리스너
    ActionListener btnDeleteL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int row = updateView.getTable().getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(mainFrame, "삭제할 영화를 선택해주세요.", "알림", JOptionPane.PLAIN_MESSAGE);
                return;
            }

            int answer = JOptionPane.showConfirmDialog(mainFrame, "정말로 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (answer == JOptionPane.YES_OPTION) {
                try {
                    MovieVO vo = updateView.neededUpdateData();
                    repository.delete(vo.getMovieId());
                    refreshAllViews();
                    JOptionPane.showMessageDialog(mainFrame, "삭제되었습니다.", "알림", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mainFrame, "삭제 중 오류가 발생했습니다.", "오류", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    };

    // 11. 수정 탭 검색 버튼 리스너
    ActionListener btnUpdateSearchL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String word = updateView.getSearchWord();
            int index = updateView.getSelectedIndex();
            list = repository.select(word, index);
            updateView.setMovieVOList(list);
        }
    };

    // 12. 수정 탭 테이블 클릭 리스너
    MouseAdapter tableUpdateL = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = updateView.getTable().getSelectedRow();
            MovieVO vo = list.get(row);
            updateView.setFieldsFromRow(vo);
        }
    };

    // 13. 탭 변경 리스너
    ChangeListener tabL = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            refreshAllViews();
        }
    };

    // ====================================
    // 프로그램 실행
    // ====================================
    public static void main(String[] args) {
        new MovieController();
    }
}