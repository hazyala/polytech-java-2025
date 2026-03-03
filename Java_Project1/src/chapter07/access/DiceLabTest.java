package chapter07.access;

public class DiceLabTest {
    public static void main(String[] args) {
        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();

        int count = 0;

        while (true) {
            count++;
            d1.setNumber((int)(Math.random() * 6 + 1)); //1~6까지의 임의 숫자가 주사위 객체에 설정
            d2.setNumber((int)(Math.random() * 6 + 1));
            d3.setNumber((int)(Math.random() * 6 + 1));

            if (d1.getNumber() == d2.getNumber() && d1.getNumber() == d3.getNumber()) {
                break;
            }

            System.out.println("3개 주사위의 숫자가 모두 " + d1.getNumber() + "입니다.");
            System.out.println("3개의 주사위의 숫자가 모두 같아지는데 " + count + "번 던졌습니다.");
        }
    }
}
