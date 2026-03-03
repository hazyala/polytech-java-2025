package chapter06;

public class ForTest4 {
    public static void main(String[] args) {
        int n = 1000;
        int sum = 0;
        String oddEven = "";
        for (int i = 1; i <= n; i++) {
            if(i % 2 != 0) {
                sum += i; // sum = sum + i
                oddEven = "홀수";
            }
        }
//        System.out.println("1 ~ " + n + "까지의 합계는 "+sum+"이다.");
        System.out.println("1 ~ " + n + "까지의 " + oddEven + "의 합계는 "+sum+"이다.");
    }
}