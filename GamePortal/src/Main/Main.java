package Main;

import BulletDodger.*;
import Pong.*;
import Jumper.*;
import processing.core.PApplet;

public class Main extends PApplet {
    public static int mousePos;
    public static int h;
    public static int w;
    public static boolean spacePressed = false;
    public static boolean wPressed = false;
    public static boolean aPressed = false;
    public static boolean sPressed = false;
    public static boolean dPressed = false;

    public enum GameState{
        CHOOSE,
        BULLETDODGER,
        PONG,
        JUMPER
    }
    Pong pongGame;
    Jumper jumperGame;
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
                text("Jumper",width/2,height/2+10);
                text("Bullet Dodger",3*width/4,height/2+10);

            }
            case BULLETDODGER -> {
                bulletDodgerGame.tick();
                drawBulletDodger(bulletDodgerGame);
            }
            case PONG -> {
                pongGame.tick();
                drawPong(pongGame);
            }
            case JUMPER -> {
                jumperGame.tick();
                drawJumper(jumperGame);
            }
        }
    }
    public void keyPressed(){
        switch (key){
            case 'w'->wPressed = true;
            case 'a'->aPressed = true;
            case 's'->sPressed = true;
            case 'd'->dPressed = true;
            case ' '->spacePressed = true;
        }
    }
    public void keyReleased(){
        switch (key){
            case 'w'->wPressed = false;
            case 'a'->aPressed = false;
            case 's'->sPressed = false;
            case 'd'->dPressed = false;
            case ' '->spacePressed = false;
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
                        state = GameState.JUMPER;
                        jumperGame = new Jumper();
                        jumperGame.play();
                        drawJumper(jumperGame);
                    }
                    else if (mouseX > width*3 / 4 - 100 && mouseX < width*3 / 4 + 100){
                        state = GameState.BULLETDODGER;
                        bulletDodgerGame = new BulletDodger();
                        bulletDodgerGame.play();
                        drawBulletDodger(bulletDodgerGame);
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
            case JUMPER -> {
                if (jumperGame.gameOver){
                    if (mouseY>height/2&&mouseY<height/2+100){
                        if (mouseX > width/2+50&&mouseX<width/2+250){
                            jumperGame.play();
                        }
                        else if (mouseX>width/2-250&&mouseX<width/2-50){
                            state = GameState.CHOOSE;
                        }
                    }

                }
            }
            case BULLETDODGER -> {
                if (bulletDodgerGame.gameOver){
                    if (mouseY>height/2&&mouseY<height/2+100){
                        if (mouseX > width/2+50&&mouseX<width/2+250){
                            bulletDodgerGame.play();
                        }
                        else if (mouseX>width/2-250&&mouseX<width/2-50){
                            state = GameState.CHOOSE;
                        }
                    }

                }
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
    void drawBulletDodger(BulletDodger game){
        fill(0,200,0);
        rect(0,0,width,height);

        fill(240,180,140);
        rect(width/2-game.playerSize/2,height/2-game.playerSize/2,game.playerSize,game.playerSize);
        fill(120);
        for (Bullet b:game.bullets){
            circle(b.posX-game.player.posX,b.posY-game.player.posY,game.bulletSize);
        }
        if (bulletDodgerGame.gameOver){
            textSize(80);
            text("Score: "+bulletDodgerGame.score,width/2,height/2-100);
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
    void drawJumper(Jumper game){
        fill(150, 150, 250);
        rect(0, 0, width, height - game.height);
        fill(0, 200, 20);
        rect(0, height - game.height, width, 50);
        fill(80, 30, 0);
        rect(0, height - game.height + 50, width, game.height - 50);

        fill(240,180,140);
        circle(100F, (float) (height - game.player.posY - Math.ceil(game.playerSize / 2)), game.playerSize);

        fill(255, 0, 0);
        rect(game.obstacle.posX - game.obstacleSize/2, height - game.obstacle.posY - game.obstacleSize, game.obstacleSize, game.obstacleSize);
        fill(0);
        if (!game.gameOver) {
            text("Score: " + game.score, width / 2, 100);
        }

        if (jumperGame.gameOver){
            textSize(80);
            text("Score: "+jumperGame.score,width/2,height/2-100);
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
}