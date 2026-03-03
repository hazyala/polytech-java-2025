package chapter08.section01;

public class RabbitTest1 {
    public static void main(String[] args) {
        System.out.println("Rabbit 객체 생성전의 토끼 객체의 수 :" + Rabbit.cnt);

        Rabbit r1 = new Rabbit();
        System.out.println("Rabbit 객체 첫 번째 생성 후의 토끼 객체의 수 :" + Rabbit.RABBIT_NAME +""+ Rabbit.cnt);

        Rabbit r2 = new Rabbit();
        System.out.println("Rabbit 객체 두 번째 생성 후의 토끼 객체의 수 :" + Rabbit.RABBIT_NAME +""+ Rabbit.cnt);
    }
}
