package chapter03;

public class Code03_Lab02 {
    public static void main(String[] args) {

        System.out.println("\n============ 편의점 일일 매출 계산기 =============\n");

        int total = 0;

        total -= 900*10; // 삼각김밥 10개 구입
        total -= 3500*5; // 도시락 5개 구입

        total += 1800*2; // 바나나맛 우유 2개 판매
        total += 4000*4; // 도시락 4개 판매
        total += 1500; // 콜라 1개 판매
        total += 2000*4; // 새우깡 4개 판매
        total += 1800*5; // 캔커피 5개 판매

        System.out.println("Java 편의점 오늘 총 매출액은 " + total + " 원 입니다. ");

    }
}

