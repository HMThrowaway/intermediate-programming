package Pong;
import Main.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Pong implements Game {
    int playerSpeed = 20;
    public Ball ball;
    public HumanPlayer player1;
    public RobotPlayer player2;
    public int playerSize = 100;
    public boolean gameOver;
    public int score;

    @Override
    public String getGameName() {
        return "Pong";
    }

    @Override
    public void play() {
        player1 = new HumanPlayer(playerSpeed,playerSize);
        player2 = new RobotPlayer(playerSpeed,playerSize);
        ball = new Ball(25);

        player1.pos = (double) Main.w /2;
        player2.pos = (double) Main.w /2;

        ball.posX = (double) Main.w /2;
        ball.posY = (double) Main.h /2;

        score = 0;
        gameOver = false;
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
            if (score>pongHighScore){
                pongHighScore = score;
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
            ball.move();
            player1.move(Main.mousePos);
            player2.move(ball.posX);
            if (checkWallCollision()) {
                ball.wallBounce();
            }
            if (checkPlayerCollision()) {
                score++;
                ball.playerBounce();
            } else {
                switch (checkLoss()) {
                    case 1,-1 -> {
                        writeHighScore(new File("src/Main/HighScores.txt"));
                        gameOver = true;
                    }
                }
            }
        }
    }
    boolean checkWallCollision(){
        return (ball.posX > Main.w - ball.size &&ball.velocityX>0) || (ball.posX < ball.size&&ball.velocityX<0);
    }
    boolean checkPlayerCollision() {
        return (ball.posY > Main.h - 50 - ball.size && Math.abs(player1.pos - ball.posX) <= playerSize / 2 && ball.velocityY>0) || (ball.posY < 50 + ball.size && Math.abs(player2.pos - ball.posX) <= playerSize / 2&&ball.velocityY<0);
    }
    int checkLoss(){
        if (ball.posY <= ball.size){
            return 1;
        }
        else if (ball.posY >= Main.h - ball.size){
            return -1;
        }
        else {
            return 0;
        }
    }
}
