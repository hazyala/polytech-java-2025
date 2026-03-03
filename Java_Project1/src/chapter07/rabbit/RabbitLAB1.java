package chapter07.rabbit;

import java.util.Scanner;

public class RabbitLAB1 {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Rabbit rabbit = new Rabbit();
        int x=0, y=0;

        while(true){
            System.out.println("토끼가 이동할 X좌표 : ");
            x = s1.nextInt();
            System.out.println("토끼가 이동할 Y좌표 : ");
            y = s1.nextInt();

            rabbit.setPosition(x, y);
            rabbit.move();

        }
    }
}
