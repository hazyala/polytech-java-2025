package chapter08.section02;

public class RabbitTest {
    public static void main(String[] args) {
        HouseRabbit h1 = new HouseRabbit();
        MoutainRabbit m1 = new MoutainRabbit();

        h1.ownerName = "오폴리";
        //shape 필드와 move()메소드에 private 접근제한자로 인해 subclass가 접근이 불가능
        //superclass와 subclass가 [같은] 패키지 내에 있을 때 접근 가능하려면 : public, default, protected
        //superclass와 subclass가 [다른] 패키지 내에 있을 때 접근 가능하려면 : public, protected
//        h1.shape = "그라미";
        h1.move(50,70);
        h1.eatFeed();

        m1.moutainName = "남산";
//        m1.shape = "네모";
        m1.move(200,700);
        m1.eatWildglass();
    }
}
