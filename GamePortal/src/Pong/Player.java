package Pong;

public abstract class Player {
    double speed;
    public double pos;
    double size;
    Player (int movementSpeed, int playerSize) {
        speed = movementSpeed;
        size = playerSize;
    }
}
