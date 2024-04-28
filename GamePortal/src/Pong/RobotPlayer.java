package Pong;
import Main.*;

public class RobotPlayer extends Player{
    RobotPlayer(int movementSpeed, int playerSize) {
        super(movementSpeed,playerSize);
    }

    void move(double ballPos){
        if (ballPos>pos){
            pos+= Math.min(speed,Math.abs(pos-ballPos));
        }
        else {
            pos-= Math.min(speed,Math.abs(pos-ballPos));
        }
        pos = Math.max(pos,0);
        pos = Math.min(Main.w,pos);
    }
}
