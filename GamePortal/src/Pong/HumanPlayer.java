package Pong;

public class HumanPlayer extends Player{
    HumanPlayer(int movementSpeed, int playerSize) {
        super(movementSpeed,playerSize);
    }

    void move(int position){
        pos = position;
    }
}
