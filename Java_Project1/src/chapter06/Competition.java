package chapter06;

import java.util.Scanner;

public class Competition {
    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);
        int computernum = 0 , usernum = 0 ;

        for (int i = 0; i < 10 ; i++) {
            // 1~5의 임의의 숫자
            computernum = (int)(Math.random() * 5 + 1);

            System.out.println("게임" +  (i + 1) + "회");
            System.out.println("사용자가 생각하는 숫자 입력 (1~5 사이 중)");
            usernum = s1.nextInt();

            if (computernum == usernum) {
                System.out.println("축하합니다. 제 생각과 일치했습니다.");
                break;
            }else {
                System.out.printf("제가 생각한 숫자는 %d 였습니다. \n" , computernum);
                continue;
            }
        }
        System.out.println("게임을 종료합니다. ");
    }
}
