package Jumper;
import Main.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Jumper implements Game{
    public Player player;
    public Obstacle obstacle;
    int speed;
    public int score;
    public int obstacleSize = 50;
    public int playerSize = 100;
    public int height = 100;
    public boolean gameOver;
    @Override
    public String getGameName() {
        return "Jumper";
    }

    @Override
    public void play() {
        gameOver = false;
        score = 0;
        player = new Player(height,30,playerSize);
        obstacle = new Obstacle(speed,obstacleSize,height);
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
            if (score>jHighScore){
                jHighScore = score;
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
            obstacle.speed = score+5;
            if (Main.spacePressed) {
                player.jump();
            }
            if (obstacle.posX<100+playerSize/2+obstacleSize/2&& obstacle.posX>100-playerSize/2-obstacleSize/2 &&player.posY<height+obstacleSize){
                writeHighScore(new File("src/Main/HighScores.txt"));
                gameOver = true;
            }
            player.move();
            obstacle.move();
            if (obstacle.posX<-obstacle.size){
                obstacle.posX = Main.w+obstacle.size;
                score++;
            }
        }
    }
}
