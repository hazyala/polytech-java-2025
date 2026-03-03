package chapter06;

public class ContinueTest {
    public static void main(String[] args) {
        int sum = 0 ;
        for (int i = 1 ; i <= 100 ; i++) {
            //5의 배수
            if (i % 5 == 0)
                continue;
            sum += i;
        }
        System.out.println("1 ~ 100 까지의 합계 : " + sum);
    }
}
