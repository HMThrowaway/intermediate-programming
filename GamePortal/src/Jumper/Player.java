package Jumper;

public class Player {
    public int posY;
    int velocity;
    int maxY;
    int jumpHeight;
    int size;
    Player(int max, int jump, int s){
        maxY = max;
        jumpHeight = jump;
        size = s;
    }
    void move(){
        if (posY>=maxY) {
            posY += velocity;
            velocity--;
        }
        else {
            velocity = 0;
            posY = maxY;
        }
    }
    public void jump(){
        if (posY==maxY){
            velocity = jumpHeight;
        }
    }

}
