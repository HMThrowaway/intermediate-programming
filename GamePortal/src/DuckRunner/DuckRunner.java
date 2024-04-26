package DuckRunner;

import Main.Game;
import processing.core.PApplet;

import java.io.File;

public class DuckRunner extends PApplet implements Game {
    @Override
    public String getGameName() {
        return "Duck Runner";
    }

    @Override
    public void play() {
        //PApplet.main("DuckRunner.DuckRunner");
        //fill(0,0,255);
        //rect(0,0,width,height);
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public void writeHighScore(File f) {

    }
}
