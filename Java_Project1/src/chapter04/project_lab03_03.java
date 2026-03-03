package chapter04;
import java.util.Scanner; // 사용자 입력을 받기 위한 Scanner 클래스 임포트

public class project_lab03_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 사용자로부터 입력을 받을 Scanner 객체 생성

        String subject;  // 과목명을 저장할 문자열 변수
        int credit;      // 이수 학점을 저장할 정수형 변수
        String grade;    // 성적 등급을 저장할 문자열 변수

        double totalScore = 0;   // 누적된 (학점 × 평점)을 저장할 변수
        int totalCredits = 0;    // 총 이수 학점 누적 변수

        // 프로그램 시작 안내 메시지로 C언어에서 만들었던 계산기를 토대로 자바 언어로 응용시켜봄
        System.out.println("성적 입력을 시작합니다. 종료하려면 과목명에 'E'를 입력하세요.\n");

        // 무한 반복을 통해 계속해서 필요한 만큼의 과목 정보를 입력받음
        while (true) {
            System.out.print("과목명을 입력하세요 (E 입력 시 종료): ");
            subject = sc.next(); // 과목명 입력 받기

            if (subject.equals("E")) break; // 사용자가 필요한 과목을 전부 입력하고 'E'를 입력하면 반복 종료 후 탈출

            System.out.print("이수 학점을 입력하세요: ");
            credit = sc.nextInt(); // 해당 과목의 이수 학점 입력 받기

            // 교재에는 A = 4.5, A0 = 4.0, B = 3.5 밖에 없으나 완벽한 성적 계산기를 만들기 위해 F 성적까지 추가
            System.out.print("성적 등급을 입력하세요 (A, A0, B, B0, C, C0, D, D0, F): ");
            grade = sc.next(); // 해당 과목의 성적 등급 입력 받기

            double score; // 해당 등급에 대응되는 점수를 저장할 변수

            // 입력한 성적 등급에 따라 점수를 지정하여 성적 등급을 입력하면 점수로 자동 환산 되도록 함
            switch (grade) {
                case "A": score = 4.5; break; // A → 4.5 로 점수 환산
                case "A0":  score = 4.0; break; // A0  → 4.0 로 점수 환산
                case "B": score = 3.5; break; // B → 3.5 로 점수 환산
                case "B0":  score = 3.0; break; // B0 → 3.0 로 점수 환산
                case "C": score = 2.5; break; // C → 2.5 로 점수 환산
                case "C0":  score = 2.0; break; // C0 → 2.0 로 점수 환산
                case "D": score = 1.5; break; // D → 1.5 로 점수 환산
                case "D0":  score = 1.0; break; // D0 → 1.0 로 점수 환산
                case "F":  score = 0.0; break; // F → 0 로 점수 환산
                default:
                    // 위에 해당하지 않는 등급이 들어온 경우 경고 메시지를 출력하고 계속 반복
                    System.out.println("잘못된 성적입니다. 다시 입력해주세요.");
                    continue;
            }

            // 과목, 학점, 등급을 그대로 출력 (등급은 입력한 그대로 보여줌)
            System.out.printf("과목명 : %s, 학점: %d, 등급: %s\n", subject, credit, grade);

            // 총 점수 계산: (해당 과목의 학점 × 평점)을 누적
            totalScore += score * credit;

            // 총 학점 누적
            totalCredits += credit;
        }

        // 모든 입력이 끝난 후, 평균 평점을 계산하여 출력
        if (totalCredits > 0) {
            double avg = totalScore / totalCredits; // 평균 계산
            avg = Math.round(avg * 100.0) / 100.0;  // 소수 둘째 자리 반올림 처리
            System.out.printf("\n최종 평균 평점: %.2f\n", avg); // 결과 출력
        } else {
            // 과목이 하나도 입력되지 않았을 경우
            System.out.println("입력된 과목이 없습니다.");
        }

        sc.close(); // Scanner 객체 닫기
    }
}
