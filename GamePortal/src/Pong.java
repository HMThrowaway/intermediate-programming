import processing.core.PApplet;

import java.io.File;

public class Pong extends PApplet implements Game{

    @Override
    public String getGameName() {
        return "Pong";
    }

    @Override
    public void play() {
        boolean running = true;
        while (running){

        }
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public void writeHighScore(File f) {

    }
}
