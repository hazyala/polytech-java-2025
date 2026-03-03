package chapter05;

import java.util.Calendar;
import java.util.Scanner;

public class LAB_chapter05_1 {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("=========== PC방 출입 금지 시간 제한 ===========");
        System.out.println("* 출생년도 입력 (4자리 점수로) : ");
        int birthYear = s1.nextInt();

        Calendar calendar = Calendar.getInstance();
        int nowYear = calendar.get(Calendar.YEAR);

        int age = nowYear - birthYear;
        String resultStr = "";

        if (age >= 18) {
            resultStr = "즐거운 시간 보내세요~";
        }
        else {
            resultStr = "집에 가실 시간입니다~";
        }
        System.out.println("귀하의 나이는 " + age + "세이므로 " + resultStr);
        System.out.println("협조해 주셔서 정말 감사합니다");

        s1.close();
    }
}
