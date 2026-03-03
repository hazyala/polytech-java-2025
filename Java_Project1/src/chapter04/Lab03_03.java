package chapter04; // chapter04라는 패키지에 포함되어 있는 클래스

public class Lab03_03 {
    public static void main(String[] args) { // main 함수

        int java = 3, mobile = 2, exel = 1; // int(정수 자료형)로 지정한 각 변수는 각 과목별 학점 수 의미
        double A = 4.5, A0 = 4.0, B = 3.5; // double(실수 자료형)로 지정한 각 변수는 각 등급에 해당하는 평점 의미

        double avg; // 평균 학점을 저장할 변수 선언, double 형으로 지정한 이유는 소수 계산 때문
        avg = ((java * B) + (mobile * A0) + (exel * A)) / (java + mobile + exel);  // (과목별 평점 * 학점)을 다 더하고, 총 학점으로 나눔
        avg = Math.round(avg * 100.0) / 100.0;
        // Math.round(): 소수 첫째 자리에서 반올림하는 자바 내장 함수
        //avg*100.0 = 383.333.... => Math.round로 383이 됨 => 다시 100.0으로 나누면 3.83 으로 소수 둘째 자리에서 반올림한 효과

        System.out.println("평균 학점 : " + avg);  // 결과 출력
    }
}
