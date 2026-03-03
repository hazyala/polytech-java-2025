package chapter07.access;

public class RabbitPrivate {
    private String shape;
    int x, y;

    void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
