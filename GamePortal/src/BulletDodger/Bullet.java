package BulletDodger;

public class Bullet {
    public int size;
    public int posX;
    public int posY;
    int velocityX;
    int velocityY;
    int speed;
    String direction;
    Bullet(int s,int X, int Y, String t, int sp){
        size = s;
        speed = sp;
        posX = X;
        posY = Y;
        direction = t;
        switch (direction){
            case "UP" ->{
                velocityY = -speed;
                velocityX = 0;
            }
            case "DOWN" -> {
                velocityY = speed;
                velocityX = 0;
            }
            case "RIGHT" -> {
                velocityY = 0;
                velocityX = speed;
            }
            case "LEFT" -> {
                velocityY = 0;
                velocityX = -speed;
            }
        }
    }
    void move(){
        posX += velocityX;
        posY += velocityY;
    }
}
