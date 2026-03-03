package chapter07.car;

public class Car {
    // 속성과 기능 (단순화 : 추상화)
    // 속성 => 필드로 표현
    // 기능 => 메소드 표현

    //속성
    private String name;
    private String product;
    private int price;
    private int year;
    private int cc;

    // 필드 (속성) 값을 설정
    public void setName(String name){
        this.name = name;
    }

    // 필드 (속성) 값을 반환
    public String getName(){
        return name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    // 메소드 (기능)
    public void start(){
        System.out.println("시동을 건다");
    }
    public void drive(int speed){
        System.out.println("시속" + speed + "로 달린다.");
    }
    public void forward(){
        System.out.println("전진한다.");
    }

    public void backward(){
        System.out.println("후진한다.");
    }

    public void stop(){
        System.out.println("정지한다.");
    }

    public Car() {
        super();
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", cc=" + cc +
                '}';
    }
}