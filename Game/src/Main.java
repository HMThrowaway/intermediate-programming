import processing.core.PApplet;

import java.io.File;

public class Main extends PApplet {
    enum GameState{
        START,
        LOADING,
        RUNNING
    }
    enum SelectedShopMode {
        SELL,
        BUY
    }

    GameState state = GameState.START;
    SelectedShopMode shopMode = SelectedShopMode.BUY;
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
        frameRate = 60;
        System.out.println(height);
        System.out.println(width);
        textAlign(CENTER);
        savesDirectorySize = getDirectorySize("Saves");
        drawLoad = savesDirectorySize!=0;

    }

    @Override
    public void draw() {
        switch (state){
            case START -> drawStartScreen();
            case LOADING -> drawLoadScreen();
            case RUNNING -> drawGame();

        }
    }

    @Override
    public void mousePressed() {
        switch (state) {
            case START -> {
                if (mouseX > width / 2 - height*10/147 && mouseX < width / 2 + 100) {
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
            case RUNNING -> {
                if (mouseX > width*7/8){
                    
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
    public void drawGame(){
        game.tick();
        background(255);

        textAlign(LEFT);
        textSize(70);
        if (shopMode==SelectedShopMode.BUY){
            fill(0);
            rect(width*7/8,0, width/16,height/11);
            fill(255);
            rect(width*15/16,0, width/16,height/11);
            text("Buy",width*7/8+width/200,height/15);
            fill(0);
            text("Sell",width*15/16+width/200,height/15);
        }
        else {
            fill(255);
            rect(width*7/8,0, width/16,height/11);
            fill(0);
            rect(width*15/16,0, width/16,height/11);
            text("Buy",width*7/8+width/200,height/15);
            fill(255);
            text("Sell",width*15/16+width/200,height/15);
        }
        for (int i = 0; i < game.items.length; i++) {
            drawItemButton(i);
        }

        fill(0);
        textSize(50);
        text("Money Per Second: " + game.moneyPerSecond, 10,height-15);

    }
    public void drawItemButton(int index){
        if (game.items[index].price > game.money){
            fill(255,200,200);
        } else{
            fill(200,255,200);
        }
        rect(7*width/8,(1+index)*height/11,width/8,height/11);
        fill(0);
        textSize(50);
        text(game.items[index].name+": "+game.items[index].amount,7*width/8+10,(13+index*8)*height/88);
        textSize(20);
        text("Price: "+game.items[index].price,7*width/8+width/200,(10+index*8)*height/88);
        text("Total CPS: "+game.items[index].moneyPerSecond,7*width/8+width/200,(15+index*8)*height/88);
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
