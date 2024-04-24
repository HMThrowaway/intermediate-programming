import processing.core.PApplet;

import java.io.File;

public class BulletDodger extends PApplet implements Game{

    @Override
    public String getGameName() {
        return "Bullet Dodger";
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
