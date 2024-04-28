package Pong;
import java.util.Random;

public class Ball {
    Random r = new Random();
    public double posX;
    public double posY;
    double velocityX = 0;
    double velocityY = 0;
    int maxStartVelocity = 10;
    public int size;
    Ball(int ballSize){
        size = ballSize;
        while (velocityX ==0||velocityY==0) {
            velocityX = r.nextInt(maxStartVelocity * 2) - maxStartVelocity;
            velocityY = r.nextInt(maxStartVelocity * 2) - maxStartVelocity;
        }
    }
    void move(){
        posY += velocityY;
        posX += velocityX;
    }
    void wallBounce(){
        if (velocityX>0) {
            velocityX = -(velocityX + r.nextInt(5));
        }
        else {
            velocityX = -(velocityX - r.nextInt(5));
        }
    }
    void playerBounce(){
        if (velocityY>0) {
            velocityY = -(velocityY + r.nextInt(5));
        }
        else {
            velocityY = -(velocityY - r.nextInt(5));
        }
    }
}
