package BulletDodger;

import Main.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BulletDodger implements Game {
    String[] types = new String[]{"UP","DOWN","LEFT","RIGHT"};
    Random r = new Random();
    public boolean gameOver;
    public Player player;
    public ArrayList<Bullet> bullets;
    public int bulletSize = 40;
    public int playerSize = 80;
    int bulletSpeed = 15;
    public int score;

    @Override
    public String getGameName() {
        return "Bullet Dodger";
    }

    @Override
    public void play() {
        player = new Player();
        score = 0;
        gameOver = false;
        bullets = new ArrayList<>();
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void writeHighScore(File f) {
        try {
            Scanner sc = new Scanner(f);
            int pongHighScore = sc.nextInt();
            int jHighScore = sc.nextInt();
            int bdHighScore = sc.nextInt();
            if (score>bdHighScore){
                bdHighScore = score;
                FileWriter fw = new FileWriter(f);
                fw.write(pongHighScore+"\n"+jHighScore+"\n"+bdHighScore);
                fw.close();
            }
        } catch (IOException ignored){
            System.out.println("womp womp rip filename");
        }
    }
    public void tick(){

        if (!gameOver) {
            if (r.nextInt(80-score/5) == 0) {
                score++;
                String type = types[r.nextInt(4)];
                int XOffset = player.posX;
                int YOffset = player.posY;
                switch (type) {
                    case "UP" -> {
                        bullets.add(new Bullet(bulletSize, XOffset + r.nextInt(Main.w - 400) + 200, YOffset + Main.h, "UP", bulletSpeed));
                    }
                    case "DOWN" -> {
                        bullets.add(new Bullet(bulletSize, XOffset + r.nextInt(Main.w - 400) + 200, YOffset, "DOWN", bulletSpeed));
                    }
                    case "RIGHT" -> {
                        bullets.add(new Bullet(bulletSize, XOffset, YOffset + r.nextInt(Main.h - 400) + 200, "RIGHT", bulletSpeed));
                    }
                    case "LEFT" -> {
                        bullets.add(new Bullet(bulletSize, XOffset + Main.w, YOffset + r.nextInt(Main.h - 400) + 200, "LEFT", bulletSpeed));
                    }
                }
            }
            for (Bullet b : bullets) {
                b.move();
                if (Math.abs(b.posX - player.posX-Main.w/2) < playerSize/2+bulletSize/2 && Math.abs(b.posY - player.posY-Main.h/2) < playerSize/2+bulletSize/2) {
                    writeHighScore(new File("src/Main/HighScores.txt"));
                    gameOver = true;
                }
            }
            player.move();
        }
    }
}
