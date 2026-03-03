package chapter02;

public class Code02_09 {
    public static void main(String[] args) {

    int num1 = 10, num2 = 20;
    double result;

    result = num1 + num2;
    System.out.printf("%d + %d = %.1f\n", num1, num2, result);

    result = num1 - num2;
    System.out.printf("%d - %d = %.1f\n", num1, num2, result);

    result = num1 * num2;
    System.out.printf("%d * %d = %.1f\n", num1, num2, result);

// 정수형 / 정수형 => 정수부만 저장
// 정수형 둘 중에 하나를 실수형으로 변환해서 연산
    result = num1 / (double)num2;
    System.out.printf("%d / %d = %.1f\n", num1, num2, result);

    }
}
