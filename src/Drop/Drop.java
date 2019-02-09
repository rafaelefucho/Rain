package Drop;

import java.util.concurrent.ThreadLocalRandom;

public class Drop {

    int x;
    int y;
    int y_speed;

    public Drop(int x, int y, int y_speed) {
        this.x = x;
        this.y = y;
        this.y_speed = y_speed;
    }

    public Drop(){

        this.x = ThreadLocalRandom.current().nextInt(0, 640 + 1);
        this.y = ThreadLocalRandom.current().nextInt(100, 150 + 1) * (-1);;
        this.y_speed = ThreadLocalRandom.current().nextInt(4, 10 + 1);

    }
    public void updateY(){

        y = y + y_speed;

        if (y > 360){
            this.y = ThreadLocalRandom.current().nextInt(0, 100 + 1) * (-1);;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY_speed() {
        return y_speed;
    }

    public void setY_speed(int y_speed) {
        this.y_speed = y_speed;
    }
}
