package chapter03;

public class Code03_09 {
    public static void main(String[] args) {

        int num1 = 1;
        int num2 = 2;

//        num1 = num1 + num2;
        num1 += num2;
        System.out.println(num1);

        int num =5;

        int result = 10 * 2 + num++;
        System.out.println(result);
        System.out.println(num);

        num = 5;
        result = 10 * 2 + ++num;
        System.out.println(result);
        System.out.println(num);

    }
}
