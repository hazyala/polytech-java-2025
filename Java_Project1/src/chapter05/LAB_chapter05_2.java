package chapter05;

import java.util.Scanner;

public class LAB_chapter05_2 {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("============= 가위, 바위, 보 게임 =============");
        System.out.println("* 가위, 바위, 보 중 하나를 입력 : ");
        String myHand = s1.nextLine();

        String[] hands = {"가위", "바위", "보"};
        int randomIndex = (int)(Math.random() * hands.length);
        String computerHand = hands[randomIndex];
//      String computerHand = hands[(int)(Math.random() * hands.length)];로 해도 동일

        if (myHand.equals("가위"))
        {
            if(computerHand.equals("가위"))
                System.out.println("비겼습니다");
            else if (computerHand.equals("바위"))
                System.out.println("졌습니다");
            else
                System.out.println("이겼습니다");
        }

        else if (myHand.equals("바위"))
        {
            if(computerHand.equals("가위"))
                System.out.println("이겼습니다");
            else if (computerHand.equals("바위"))
                System.out.println("비겼습니다");
            else
                System.out.println("졌습니다");
        }

        else if (myHand.equals("보"))
        {
            if(computerHand.equals("가위"))
                System.out.println("졌습니다");
            else if (computerHand.equals("바위"))
                System.out.println("이겼습니다");
            else
                System.out.println("비겼습니다");
        }

        else System.out.println("가위, 바위, 보 문자열 중  하나를 입력하세요");

        s1.close();
    }
}
