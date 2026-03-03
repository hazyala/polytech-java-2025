package chapter05;

import java.util.Calendar;

public class Code5_09 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK); //0~6

        System.out.println("현재 요일 번호 : " + day);
        char dayCh = 0;

        switch (day)
        {
            case 1: dayCh = '일'; //case Calender.SUNDAY와 같은 식으로 상수를 활용하연 가독성 향상
                break;
            case 2: dayCh = '월'; //case Calender.MONDAY
                break;
            case 3: dayCh = '화'; //case Calender.TUESDAY
                break;
            case 4: dayCh = '수'; //case Calender.WEDNESDAY
                break;
            case 5: dayCh = '목'; //case Calender.THURSDAY
                break;
            case 6: dayCh = '금'; //case Calender.FRIDAY
                break;
            case 7: dayCh = '토'; //case Calender.SATURDAY
                break;
        }

        System.out.println("오늘은 " + dayCh + "요일입니다.");
    }
}
