package chapter07.access;

public class RabbitPublicTest {
    public static void main(String[] args) {
        RabbitPublic r1 = new RabbitPublic();
        r1.shape = "Circle";
        r1.x = 70;
        r1.y = 30;

        System.out.println("토끼모양: " + r1.shape);
        System.out.println("토끼 현재 위치 : ("+ r1.x+","+ r1.y+")");
    }
}
