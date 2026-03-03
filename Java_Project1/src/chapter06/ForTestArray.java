package chapter06;

public class ForTestArray {
    public static void main(String[] args) {
        String[][] teamNames = {{"김나현", "김예진", "김재영", "김지혁"}, {"김해민", "김호석", "도경진"}, {"박경구", "박성준", "박준범", "박찬웅"}};

        for(int i = 0; i < teamNames.length; i++) {
            System.out.print(i + 1 + "팀: ");
            for(int j = 0; j < teamNames[i].length; j++) {
                System.out.printf("%s\t", teamNames[i][j]);
            }
            System.out.println();
        }
    }
}
