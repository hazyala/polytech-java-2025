package chapter05;

import java.util.Scanner;

public class Code5_05 {
    public static void main(String[] args) {
        Scanner s1=new Scanner(System.in);

        System.out.println("************ 홀수/짝수 구분 프로그램 ************\n");

        System.out.print("* 정수만 입력: ");
        int num =s1.nextInt();
        String resultStr = "";

        if(num % 2 == 0)
            resultStr = "짝수";
        else
            resultStr = "홀수";

        System.out.printf("### 경과: %d는 %s입니다.\n", num, resultStr);
    }
}
