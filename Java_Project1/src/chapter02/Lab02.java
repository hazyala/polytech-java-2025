package chapter02;

import java.util.Scanner;

public class Lab02 {
    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in); //정수값

        // 실수형 연산을 원하면 int 대신 double 사용하면 됨

        System.out.println (" \n ### 단순 계산기 ### \n");

        System.out.print("* 첫번째 정수값 입력 : ");
        int num1 = s1.nextInt();
        System.out.print("* 두번째 정수값 입력 : ");
        int num2 = s1.nextInt();

        //계산부분
        int result1 = num1 + num2;
        int result2 = num1 - num2;
        int result3 = num1 * num2;
        int result4 = num1 / num2;
        int resMod = num1 % num2;

        // result 1234로 하지 않아도 int에 한번에 저장하고 해도 됨
        // int resPlus, resMinus, resMultiply, resDivide, resMod -> 가 각 덧셈, 뺄셈, 곱셈, 나눗셈, 나머지 변수명 지정


        // 출력부분
        System.out.println("덧셈 결과 : " + result1);
        System.out.println("뺄셈 결과 : " + result2);
        System.out.println("곱셈 결과 : " + result3);
        System.out.println("나눗셈 결과 : " + result4);
        System.out.println("나머지 결과 : " + resMod);
        // System.out.println("%d mod %d  = %d\n", num1, num2, resMod); = System.out.println(num1 + "%" + num2 + "=" + resMod);


        //연결할 것이 너무 많을 때는 println 보다 printf를 쓰는것이 나음.
        //System.out.print("%d+%d = %d\n", num1, num2, rePlus); 와 같은 형식으로 사용

    }
}
