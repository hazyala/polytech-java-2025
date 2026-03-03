package chapter04;

public class LAB_Chapther04_02 {
    public static void main(String[] args) {
        String ss = "Java";
        System.out.println("원본 문자열 : " + ss);
        String newSS = "";

        newSS = ss.substring(0,1).toUpperCase();
        newSS = ss.substring(1,2).toUpperCase();
        newSS = ss.substring(2,3).toUpperCase();
        newSS = ss.substring(3,4).toUpperCase();

        System.out.println("변환 문자열 : ");
        System.out.println(newSS);

    }
}
