package chapter03;

import java.util.Scanner;

public class Code03_Lab01 {
    public static void main(String[] args) {

//        Scanner s = new Scanner(System.in);
//        double pound, kg;
//
//        System.out.print("파운드 (lb)를 입력하세요. : ");
//        pound = s.nextDouble();
//        kg = pound * 0.45359;
//        System.out.println(pound + "파운드 (lb)는" + kg  + "킬로그램 (kg) 입니다. " );
//
//
//        System.out.print("킬로그램 (kg)을 입력하세요. : ");
//        kg = s.nextDouble();
//        pound = kg * 0.45359;
//        System.out.println(pound + "킬로그램 (kg)" + pound  + " 파운드 (lb) 입니다. " );
//
//        s.close();

        double lb = 0.453592;
        double kg = 2.204623;

        Scanner s = new Scanner(System.in);

        System.out.print("파운드 (lb)를 압력하세요 : ");
        int num1 = s.nextInt();
        double result1 = num1 * lb;
        System.out.printf("%d파운드(lb)는 %.3f 킬로그램 (kg) 입니다.\n", num1, result1);

        System.out.print("킬로그램 (kg)를 압력하세요 : ");
        int num2 = s.nextInt();
        double result2 = num2 * kg;
        System.out.printf("%d킬로그램 (kg)은 %.3f 파운드(lb)입니다.\n", num2, result1);
         s.close();

    }
}
