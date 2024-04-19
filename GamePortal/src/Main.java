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

            }
            case TICTACTOE -> {

            }
            case PONG -> {

            }
            case CONNECTFOUR -> {

            }
        }
    }
    void runTicTacToe(){

    }
    void runPong(){

    }
    void runConnectFour(){

    }
}