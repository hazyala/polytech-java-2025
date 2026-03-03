package chapter04;

import java.util.Scanner;

public class Code4_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an decimal String1: ");
        String str1 = sc.nextLine();
        System.out.print("Enter an decimal String2: ");
        String str2 = sc.nextLine();

        int diffNum = str1.length() - str2.length();
        System.out.println("number 1 And number 2 difference number : " + diffNum);
        sc.close();

    }
}
