package vendingMachine;

import java.util.Scanner;

public class Vending_Machine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] drinks = {
                "코카콜라", "포카리 스웨트", "스프라이트",
                "에너지드링크", "옥수수 수염차", "생수"
        };
        int[] prices = {2000, 2000, 2000, 2500, 1800, 1000};

        //  재고 배열: 모두 3개로 초기화
        int[] stock = {3, 3, 3, 3, 3, 3};

        System.out.print("보유 금액을 입력하세요: ");
        int userMoney = scanner.nextInt();

        while (true) {
            // 음료 목록 및 재고 출력
            System.out.println("\n===== 음료 목록 =====");
            for (int i = 0; i < drinks.length; i++) {
                System.out.println((i + 1) + ". " + drinks[i] + " - " + prices[i] + "원 (재고: " + stock[i] + "개)");
            }

            System.out.print("구매할 음료의 번호를 입력하세요 (CTRL+C로 종료): ");
            int choice = scanner.nextInt();

            if (choice < 1 || choice > drinks.length) {
                System.out.println("올바른 번호를 입력해주세요.");
                continue;
            }

            int index = choice - 1;
            String selectedDrink = drinks[index];
            int selectedPrice = prices[index];

            //  재고 확인
            if (stock[index] <= 0) {
                System.out.println("해당 음료는 품절입니다. 다른 음료를 선택해주세요.");
                continue;
            }

            System.out.println(selectedDrink + "를 선택하셨습니다. 가격: " + selectedPrice + "원");

            int thisMoney = 0;
            TimerThread timer = new TimerThread();
            timer.start();

            while (thisMoney < selectedPrice) {
                System.out.print("\n금액을 투입해주세요 (10초 이내): ");
                int coin = scanner.nextInt();
                timer.Received(true);

                if (coin <= 0) {
                    System.out.println("양의 금액만 투입할 수 있습니다.");
                    continue;
                }

                thisMoney += coin;
                System.out.println("현재까지 투입된 금액: " + thisMoney + "원");

                if (thisMoney < selectedPrice) {
                    System.out.println("금액이 부족합니다. 계속 투입해주세요.");
                    timer = new TimerThread();
                    timer.start();
                }
            }

            int change = thisMoney - selectedPrice;
            userMoney -= thisMoney;
            userMoney += change;

            //  재고 차감
            stock[index]--;

            System.out.println(selectedDrink + "가 나왔습니다.");
            if (change > 0) {
                System.out.println("잔돈 " + change + "원을 반환합니다.");
            }

            System.out.println("현재 보유 금액: " + userMoney + "원");
        }
    }
}
