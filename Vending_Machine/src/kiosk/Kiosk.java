package kiosk;

import java.util.Scanner;

public class Kiosk {
    Scanner s1 = new Scanner(System.in);
    PetProduct product;
    Cart cart = new Cart();

    public void Main() {
        while (true) {
            System.out.println("======== 반려용품 키오스크 ========");
            System.out.println("1. 고양이 용품");
            System.out.println("2. 강아지 용품");
            System.out.println("3. 프로그램 종료를 원하시면, q를 입력해주세요.");
            System.out.print(": ");
            String choice = s1.nextLine();

            if (choice.equals("1")) {
                product = new CatProduct();
                product.setList();
                ProductList();
                select();
            } else if (choice.equals("2")) {
                product = new DogProduct();
                product.setList();
                ProductList();
                select();
            } else if (choice.equalsIgnoreCase("q")) {
                System.out.println("프로그램을 종료합니다. 이용해 주셔서 감사합니다!");
                System.exit(0);
            } else {
                System.out.println("잘못된 입력입니다.\n");
            }
        }
    }

    public void ProductList() {
        product.showList();
    }

    public void select() {
        try {
            System.out.print("상품 번호 선택 : ");
            int index = Integer.parseInt(s1.nextLine()) - 1;
            String name = product.getName(index);
            int price = product.getPrice(index);
            System.out.println("[" + name + "] 선택됨");

            System.out.print("수량 입력 : ");
            int count = Integer.parseInt(s1.nextLine());

            cart.add(name, count, price);
            System.out.println("장바구니에 추가됨.\n");

            menu();
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 메인 화면으로 돌아갑니다.\n");
        }
    }

    public void menu() {
        while (true) {
            System.out.println("1. 쇼핑 계속하기");
            System.out.println("2. 장바구니 보기");
            System.out.println("3. 결제하기");
            System.out.println("4. 메인 화면으로 돌아가기");
            System.out.println("5. 프로그램 종료를 원하시면, q를 입력해주세요.");
            System.out.print(": ");
            String input = s1.nextLine();

            if (input.equals("1")) return;
            else if (input.equals("2")) cart.show();
            else if (input.equals("3")) {
                Pay();
                return;
            } else if (input.equals("4")) return;
            else if (input.equalsIgnoreCase("q")) {
                System.out.println("프로그램을 종료합니다. 이용해 주셔서 감사합니다!");
                System.exit(0);
            } else System.out.println("잘못된 입력입니다.");
        }
    }

    public void Pay() {
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.\n");
            return;
        }

        System.out.println("카드를 넣으십시오...");
        pause();
        System.out.println("카드를 읽는 중입니다...");
        pause();
        System.out.println("결제 완료. 감사합니다!\n");
        cart.clear();
    }

    private void pause() {
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
    }

    public static void main(String[] args) {
        new Kiosk().Main();
    }
}
