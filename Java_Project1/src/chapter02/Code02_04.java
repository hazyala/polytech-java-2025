package chapter02;

public class Code02_04 {
 public static void main(String[] args) {
     int a = 100;
     int b = 200;

     int c = a + b;

     System.out.println(c);

     System.out.println(a + "+" + b + " = " + c);
     System.out.printf("%d + %d = %d\n", a,b,c);

     int result = b - a;
     System.out.println(result);
     System.out.printf("%d - %d = %d\n", b,a,result);

     int num1 = 50;
     int num2 = 100;
     result = num1 * num2;

     System.out.println(result);
     System.out.printf("%d * %d = %d\n", num1,num2,result);
     System.out.println(num1 + " * " + num2 + " = " + result);

     result = num1 / num2;
     System.out.println(result);

     result = num2 / num1;
     System.out.println(result);
     System.out.printf("%d / %d = %d\n", num2, num1, result);
 }
}
