import processing.core.PApplet;

public class Main extends PApplet {
    static enum GameState{
        CHOOSE,
        BULLETDODGER,
        PONG,
        DUCKRUNNER
    }

    static GameState state = GameState.CHOOSE;
    public static void main (String[] args) {
        PApplet.main("Main");
    }
    public void settings(){
        fullScreen();
    }
    public void setup(){
        background(255);
    }
    public void draw(){
        switch (state){
            case CHOOSE -> {
                fill(255);
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

            }
            case DUCKRUNNER -> {

            }
        }
    }
    public void mousePressed(){
        switch (state){
            case CHOOSE -> {
                if(mouseY > height/2-50 && mouseY < height/2+50) {
                    System.out.println("Hello");;
                    if (mouseX > width / 4 - 100 && mouseX < width / 4 + 100){
                        state = GameState.PONG;
                    }
                    else if (mouseX > width / 2 - 100 && mouseX < width / 2 + 100){
                        state = GameState.DUCKRUNNER;
                    }
                    else if (mouseX > width*3 / 4 - 100 && 3*mouseX < width*3 / 4 + 100){
                        state = GameState.BULLETDODGER;
                    }
                }
            }
            case PONG -> {
                System.out.println("P");
            }
            case DUCKRUNNER -> {
                System.out.println("DR");
            }
            case BULLETDODGER -> {
                System.out.println("BD");
            }
        }
    }
    static void returnToChoose(){
        state = GameState.CHOOSE;
    }
}