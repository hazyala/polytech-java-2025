package chapter03;

import java.util.Scanner;

public class Code03_BMI {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("키를 입력하세요 (m 단위): ");
//        double height = scanner.nextDouble();
//
//        System.out.print("몸무게를 입력하세요 (kg 단위): ");
//        double weight = scanner.nextDouble();
//
//        double bmi = weight / (height * height);
//
//        System.out.printf("키가 %.2f이고 몸무게가 %.2f이므로 BMI는 %.2f입니다.\n", bmi);
//
//        scanner.close();

        Scanner s = new Scanner(System.in);
        System.out.println("\n ======= BMI(체질량지수) Program  =====\n");

        System.out.print("*체중 (kg) 입력 : ");
        double weight = s.nextDouble();

        System.out.print("*키 (cm) 입력 : ");
        double height = s.nextDouble();

        double bmi = weight / Math.pow(height/100,2);

        System.out.printf("당신의 체중은 %2.f kg이고 키는 2.f cm 이므로 bmi지수는 %2.f입니다.\n", weight, height, bmi);

        s.close();

    }
}
