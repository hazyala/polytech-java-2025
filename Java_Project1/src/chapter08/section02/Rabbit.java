package chapter08.section02;
//super class는 상속 받는 sub class가 모두 갖고 있는 속성(필드)과 기능(메소드)으로 구현합니다.
public class Rabbit {
    private String shape;
    int x, y;

    public Rabbit() {
        super();
        System.out.println("1. Rabbit의 생성자가 실행됨");
    }

    void move(int x, int y){
        this.x = x;
        this.y = y;
        System.out.printf("(%d, %d) 좌표로 이동합니다. \n", this.x, this.y);
    }
}
