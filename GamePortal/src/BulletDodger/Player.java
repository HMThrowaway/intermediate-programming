package BulletDodger;

import Main.Main;

public class Player {
    public int posX = 0;
    public int posY = 0;
    int speed = 10;

    void move(){
        if (Main.wPressed){
            posY -= speed;
        }
        if (Main.aPressed){
            posX -= speed;
        }
        if (Main.sPressed){
            posY += speed;
        }
        if (Main.dPressed){
            posX += speed;
        }
    }

}
