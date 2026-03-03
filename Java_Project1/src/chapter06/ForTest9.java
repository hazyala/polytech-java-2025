package chapter06;

public class ForTest9 {
    public static void main(String[] args) {
//        구구단 출력문제 2
        for (int i = 1; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d × %d = %d\t", j, i, i*j);
            }
            System.out.println();
        }
    }
}