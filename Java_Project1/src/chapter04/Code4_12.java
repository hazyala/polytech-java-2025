package chapter04;

import java.util.Scanner;

public class Code4_12 {
    public static void main(String[] args) {
       String str1 = "한국폴리텍대학 AI Software Seoul Jungsu";

       String s1 = str1.toUpperCase();
       System.out.println(s1);

       String s2 = str1.toLowerCase();
       System.out.println(s2);

       System.out.println(str1);

       String str2 = "     AI Software     Seoul     ";
       System.out.println(str2);
       String str3 = str2.trim();
       System.out.println(str3);

       String str5 = str2.replaceAll(" ", ""); //empty string; ""
       System.out.println(str5);
       String str6 = str2.replaceFirst(" ", "");
       System.out.println(str6);
    }
}
