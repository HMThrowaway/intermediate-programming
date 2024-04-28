package Main;

import BulletDodger.*;
import Pong.*;
import DuckRunner.*;
import processing.core.PApplet;

public class Main extends PApplet {
    public static int mousePos;
    public static int h;
    public static int w;
    public enum GameState{
        CHOOSE,
        BULLETDODGER,
        PONG,
        DUCKRUNNER
    }
    Pong pongGame;
    DuckRunner duckRunnerGame;
    BulletDodger bulletDodgerGame;
    public static GameState state = GameState.CHOOSE;
    public static void main (String[] args) {
        PApplet.main("Main.Main");
    }
    public void settings(){
        fullScreen();
    }
    public void setup(){
        background(255);
        h = height;
        w = width;
    }
    public void draw(){
        mousePos = mouseX;
        switch (state){
            case CHOOSE -> {
                fill(255);
                rect(0,0,width,height);
                rect(width/4-100,height/2-50,200,100);
                rect(width/2-100,height/2-50,200,100);
                rect(width*3/4-100,height/2-50,200,100);
                fill(0);
                textAlign(CENTER);

                textSize(35);
                text("Pong",width/4,height/2+10);
                text("Duck Runner",width/2,height/2+10);
                text("Bullet Dodger",3*width/4,height/2+10);

            }
            case BULLETDODGER -> {

            }
            case PONG -> {
                pongGame.tick();
                drawPong(pongGame);
            }
            case DUCKRUNNER -> {

            }
        }
    }
    public void keyPressed(){
        switch (state){
            case PONG -> {

            }
            case DUCKRUNNER -> {

            }
            case BULLETDODGER -> {

            }
        }
    }
    public void mousePressed(){
        switch (state){
            case CHOOSE -> {
                if(mouseY > height/2-50 && mouseY < height/2+50) {
                    if (mouseX > width / 4 - 100 && mouseX < width / 4 + 100){
                        state = GameState.PONG;
                        pongGame = new Pong();
                        pongGame.play();
                        drawPong(pongGame);
                    }
                    else if (mouseX > width / 2 - 100 && mouseX < width / 2 + 100){
                        state = GameState.DUCKRUNNER;
                    }
                    else if (mouseX > width*3 / 4 - 100 && mouseX < width*3 / 4 + 100){
                        state = GameState.BULLETDODGER;
                    }
                }
            }
            case PONG -> {
                if (pongGame.gameOver){
                    if (mouseY>height/2&&mouseY<height/2+100){
                        if (mouseX > width/2+50&&mouseX<width/2+250){
                            pongGame.play();
                        }
                        else if (mouseX>width/2-250&&mouseX<width/2-50){
                            state = GameState.CHOOSE;
                        }
                    }

                }
            }
            case DUCKRUNNER -> {
                System.out.println("DR");
            }
            case BULLETDODGER -> {
                System.out.println("BD");
            }
        }
    }

    void drawPong(Pong game){
        fill(255);
        rect(0,0,width,height);

        fill(255,0,0);
        circle((int)game.ball.posX,(int)game.ball.posY,game.ball.size);

        fill(0);
        rect((float) (game.player1.pos-game.playerSize/2),height-50,game.playerSize,15);
        rect((float)(game.player2.pos-game.playerSize/2),35,game.playerSize,15);

        textSize(50);
        text(pongGame.score,50,50);
        if (pongGame.gameOver){
            textSize(80);
            text("Score: "+pongGame.score,width/2,height/2-100);
            fill(255,0,0);
            rect(width/2-250,height/2,200,100);
            fill(0,255,0);
            rect(width/2+50,height/2,200,100);
            fill(0);
            textAlign(CENTER);
            text("Again",width/2+150,height/2+80);
            text("Back",width/2-150,height/2+80);
        }
    }
    void drawBulletDodger(){

    }
    void drawDuckRunner(){

    }
}