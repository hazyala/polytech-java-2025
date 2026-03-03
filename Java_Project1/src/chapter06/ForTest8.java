package chapter06;

public class ForTest8 {
    public static void main(String[] args) {
//        구구단 출력문제 1
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%d × %d = %d\t", i, j, i*j);
            }
            System.out.println();
        }
    }
}
