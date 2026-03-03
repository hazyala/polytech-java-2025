package chapter02;

import java.util.Scanner;

public class Lab01 {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in); // 문자열 입력값
        Scanner s2 = new Scanner(System.in); // 숫자 입력값

        System.out.println (" ### 복습용 실습 1 택배 보내기 프로그램 : 다음 항목을 입력하세요. ###");

        System.out.print("* 받는사람 : ");
        String name = s1.nextLine();

        System.out.print("* 주소 : ");
        String address = s1.nextLine();

        System.out.print("* 무게(g) : ");
        int g = s2.nextInt();

        //처리 (계산) : 1g 당 5원
        int price = g * 5;

        // 처리 후 출력 부분
        System.out.println("받는 사람 입력값:" + name + "님");
        System.out.println("주소 입력값:" + address);
        System.out.println("배송비:" + price + "원");


        s1.close();
        s2.close();

    }
}
