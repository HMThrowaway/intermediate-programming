import processing.core.PApplet;

import java.io.File;

public class Main extends PApplet {
    enum GameState{
        START,
        LOADING,
        RUNNING
    }

    GameState state = GameState.START;

    Game game = new Game();
    boolean drawLoad;
    int savesDirectorySize;

    public static void main(String[] args) {
        PApplet.main("Main");
    }//sets processing class
    @Override
    public void settings() {
        fullScreen();//sets screen size
    }
    @Override
    public void setup(){
        textAlign(CENTER);
        savesDirectorySize = getDirectorySize("Saves");
        drawLoad = savesDirectorySize!=0;
    }

    @Override
    public void draw() {

        switch (state){
            case START -> drawStartScreen();
            case LOADING -> drawLoadScreen();
        }
    }

    @Override
    public void mousePressed() {
        switch (state) {
            case START -> {
                if (mouseX > width / 2 - 100 && mouseX < width / 2 + 100) {
                    if (mouseY > height / 2 - 75 && mouseY < height / 2 + 25) {//checks for play button press
                        state = GameState.RUNNING;
                        game = new Game();
                    } else if (mouseY > height / 2 + 75 && mouseY < height / 2 + 175) {//checks for load button press
                        state = GameState.LOADING;
                    }
                }
            }
            case LOADING -> {
                int selectedSaveNum = -1;
                for (int i = 0; i < 7; i++) {
                    if (mouseY > height / 2 + 150 * (i - savesDirectorySize / 2) - 50
                            && mouseY < height / 2 + 150 * (i - savesDirectorySize / 2) + 50
                            && mouseX > width/2-16*getFileInDirectoryName("Saves",i).length()+40
                            && mouseX < width/2-16*getFileInDirectoryName("Saves",i).length()+40 + 32*getFileInDirectoryName("Saves",i).length()-80) {
                        selectedSaveNum = i;
                        break;
                    }
                }
                if (selectedSaveNum == -1){
                    System.out.println("Input didn't detect box");
                } else {
                    state = GameState.RUNNING;
                    game = new Game(getFileInDirectoryName("Saves",selectedSaveNum));
                    System.exit(0);
                }
            }
        }


    }
    public void drawStartScreen(){
        background(255);
        fill(255);
        rect(width/2-100,height/2-75,200,100);
        fill(0);
        textSize(70);
        text("Play",width/2,height/2);
        if (drawLoad){
            fill(255);
            rect(width/2+-100,height/2+75,200,100);
            fill(0);
            text("Load",width/2,height/2+150);
        }
    }
    public void drawLoadScreen(){
        String fileName;

        textSize(70);
        background(255);
        for (int i = 0; i<savesDirectorySize; i++){
            fileName = getFileInDirectoryName("Saves",i);
            fill(255);
            rect(width/2-16*fileName.length()+40,height/2+150*(i-savesDirectorySize/2)-50,32*fileName.length()-80,100);
            fill(0);
            text(fileName.substring(0,fileName.length()-4),width/2,height/2+150*(i-savesDirectorySize/2)+25);
        }
    }
    public int getDirectorySize(String path) {
        File directory = new File(path);
        if (directory.isDirectory()) {

            String[] arr = directory.list();

            assert arr != null;
            return arr.length;
        }
        return 0;
    }
    public String getFileInDirectoryName(String path, int index){
        File directory = new File(path);
        if (directory.isDirectory()) {

            String[] arr = directory.list();

            assert arr != null;
            return arr[index];
        }
        return null;
    }
}
