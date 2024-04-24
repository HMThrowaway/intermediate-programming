import processing.core.PApplet;

import java.io.File;

public class DuckRunner extends PApplet implements Game{
    @Override
    public String getGameName() {
        return "Duck Runner";
    }

    @Override
    public void play() {

    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public void writeHighScore(File f) {

    }
}
