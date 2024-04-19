import processing.core.PApplet;

import java.io.File;

public class Pong implements Game{

    @Override
    public String getGameName() {
        return "Pong";
    }

    @Override
    public void play() {

    }

    @Override
    public String getScore() {
        return null;
    }

    @Override
    public void writeHighScore(File f) {

    }
}
