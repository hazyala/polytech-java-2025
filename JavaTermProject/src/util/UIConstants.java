package util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class UIConstants {

    // ===============================================================
    // 1. 공통 디자인 상수 (폰트 & 색상)
    // ===============================================================

    //* 수업에서는 각 화면마다 폰트와 색상을 개별적으로 new로 생성하였으나, 유지보수의 효율성을 높이기 위해 한곳에서 상수(static final)로 통합 관리하도록 개선하였습니다.

    // 폰트 정의
    public static final Font FONT_TITLE = new Font("맑은 고딕", Font.BOLD, 22);
    public static final Font FONT_BTN = new Font("맑은 고딕", Font.BOLD, 14);
    public static final Font FONT_INPUT = new Font("맑은 고딕", Font.PLAIN, 12);
    public static final Font FONT_TABLE_HEADER = new Font("맑은 고딕", Font.BOLD, 12);
    public static final Font FONT_LABEL = new Font("맑은 고딕", Font.BOLD, 12); // ★ 누락되었던 폰트 추가!

    // 색상 정의
    public static final Color COLOR_BTN_BLUE = new Color(70, 130, 180);   // 등록/수정
    public static final Color COLOR_BTN_RED = new Color(205, 92, 92);     // 삭제
    public static final Color COLOR_BTN_GRAY = new Color(230, 230, 250);  // 검색
    public static final Color COLOR_TABLE_HEADER = new Color(240, 240, 240);
    public static final Color COLOR_WHITE = Color.WHITE;

    // ===============================================================
    // 2. 테이블 스타일 적용 메소드
    // ===============================================================

    //* 수업에서는 스타일 적용 시 매번 객체를 생성(new)해야 했으나, 메모리 낭비를 줄이고 편의성을 높이기 위해 정적(static) 메소드로 변경하여 객체 생성 없이 바로 호출할 수 있도록 심화하였습니다.

    // 테이블의 기본 스타일(행 높이, 헤더 폰트 등) 설정
    public static void setTableStyle(JTable table) {
        table.setRowHeight(25);

        JTableHeader header = table.getTableHeader();
        header.setFont(FONT_TABLE_HEADER);
        header.setBackground(COLOR_TABLE_HEADER);
        header.setReorderingAllowed(false);
    }

    // 각 칸의 너비와 정렬 설정
    public static void setColumnStyle(JTable table, int columnIndex, int width, String alignType) {
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(columnIndex).setPreferredWidth(width);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        if ("center".equals(alignType)) {
            renderer.setHorizontalAlignment(JLabel.CENTER);
        } else {
            renderer.setHorizontalAlignment(JLabel.LEFT);
        }

        columnModel.getColumn(columnIndex).setCellRenderer(renderer);
    }
}