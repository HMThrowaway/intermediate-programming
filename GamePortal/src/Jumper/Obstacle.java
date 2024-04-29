package Jumper;

import Main.Main;

public class Obstacle {
    public int posX;
    public int posY = Main.h-100;
    public int size;
    int speed;
    Obstacle(int si, int sp,int height){
        size = si;
        speed = sp;
        posY = height;
    }
    void move(){
        posX-=speed;

    }
}
