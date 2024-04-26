package Pong;
import Main.*;
import java.io.File;

public class Pong implements Game {

    @Override
    public String getGameName() {
        return "Pong";
    }

    @Override
    public void play() {
        setup();

    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public void writeHighScore(File f) {

    }
    void setup(){

    }
}
