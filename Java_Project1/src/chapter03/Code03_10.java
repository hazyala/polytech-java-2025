package chapter03;

import java.util.Scanner;

public class Code03_10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("\n=========== 운전자 합격 조회 프로그램 ===========\n");

//      정수 입력 -> 입력 받은 정수를 합격인지 불합격인지 판단 -> 결과 출력
        System.out.println("* 운전자 점수 입력 : ");
        int score = s.nextInt();

 //     입력받은 점수가 합격인지 불합격인지 판단 -> 70점 이상이면 합격, 미만이면 불합격
        String result = "";
        if (score >= 70) {
            result = "합격";

        }
        else {
            result = "불합격";
        }

//      결과 출력
        System.out.println("현재 성적을 입력한 운전자는 " + result + " 입니다.");

    }
}
