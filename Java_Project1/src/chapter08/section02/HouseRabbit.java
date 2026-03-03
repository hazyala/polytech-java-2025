package chapter08.section02;

public class HouseRabbit extends Rabbit {
    String ownerName;

    public HouseRabbit() {
        super();
        System.out.println("2. HouseRabbit의 생성자가 실행됨");
    }

    @Override
    void move(int x, int y) {
        if(x > 100){
            this.x = 100;
        }
        if(y > 100){
            this.y = 100;
        }

        System.out.printf("(%d, %d) 좌표로 이동한다. \n" , this.x, this.y);
    }

    void eatFeed(){
        System.out.println("집토끼는 사료를 먹는다.");
    }
}
