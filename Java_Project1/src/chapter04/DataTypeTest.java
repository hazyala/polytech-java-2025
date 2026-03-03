package chapter04;

    public class DataTypeTest {
        public static void main(String[] args) {
            //숫자가 아닌 자료형: boolean, char
            boolean boo1 = false;
            boolean boo2 = 100 > 200; //false
            boolean boo3 = !boo1; //true

            char ch1 = 'A';
            char ch2 = 97;

            System.out.println("ch1: " + ch1);
            System.out.println("ch2: " + ch2);
            System.out.println("ch1+3: " + (char)(ch1 + 3));

            //숫자 자료형 : 정수형, 실수형
            // 정수형 : byte, shor, int, long
            //byte byte1 = 128; //overflow로 인한 에러
            byte byte2 = 127;
            //byte byte3 = -129; //underflow로 인한 에러
            byte byte4 = byte2;
            System.out.println("byte2: " + byte2);
            System.out.println("byte4: " + byte4);

            short shor1 = 128;
            short short2 = byte2;
            //byte4 = short1-1; //에러

            int int1 = byte2;
            int int2 = shor1;
            int int3 = 1000000000;
            System.out.println("int1: " + int1);

            long long1 = byte2;
            long long2 = shor1;
            long long3 = int1;
            long long4 = (long)Math.pow(10, 10);

            System.out.println("long4: " + long4);

            //실수형 : float, double
            float float1 = 123.456f;
            float float2 = (float)200.123;
            float float4 = 100;

            double double1 = 555.456;
            double double2 = float1;
            double double3 = byte2;
            double double4 = long3;
            double double5 = 333;

            //참조형 : 클래스, 인터페이스
            String str1 = new String("hello");
            str1 = "hello";
            String str2 = new String("hello");

            boolean bool4 = str1 == str2;
            System.out.println("str1 == str2 : " + bool4);
            System.out.println("str1.equals(str2) : " + str1.equals(str2));

        }
    }
