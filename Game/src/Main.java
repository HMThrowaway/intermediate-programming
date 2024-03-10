import processing.core.PApplet;


import java.io.File;


public class Main extends PApplet {
    enum GameState {
        START,
        RUNNING
    }


    enum SelectedShopMode {
        SELL,
        BUY
    }


    GameState state = GameState.START;
    SelectedShopMode shopMode = SelectedShopMode.BUY;
    static Game game = new Game();
    boolean drawLoad;
    int savesDirectorySize;
    static int selectedSaveNum = -1;


    public static void main(String[] args) {
        PApplet.main("Main");
    }//sets processing class


    @Override
    public void settings() {
        fullScreen();//sets screen size
    }


    @Override
    public void setup() {
        frameRate = 60;
        textAlign(CENTER);
        drawLoad = savesDirectorySize != 0;


    }


    @Override
    public void draw() {
        switch (state) {
            case START -> drawStartScreen();
            case RUNNING -> drawGame();
        }
    }


    @Override
    public void mousePressed() {
        switch (state) {
            case START -> {
                if (mouseX > width / 2 - height * 10 / 147 && mouseX < width / 2 + 100) {
                    if (mouseY > height / 2 - 75 && mouseY < height / 2 + 25) {//checks for play button press
                        state = GameState.RUNNING;
                        game = new Game();
                    } else if (mouseY > height / 2 + 75 && mouseY < height / 2 + 175) {//checks for load button press
                        game = new Game("Save.txt");
                        state = GameState.RUNNING;
                    }
                }
            }
            case RUNNING -> {
                if (mouseX > 20
                        && mouseX < 20 + width/10
                        && mouseY > 20
                        && mouseY < 20 + height/15){
                    game.save();
                }
                else if (mouseX > width / 2 - 100 && width / 2 + 100 > mouseX && mouseY > height / 2 - 40 && mouseY < height / 2 + 40) {
                    game.buttonClicked();
                } else if (mouseX > width * 7 / 8) {
                    if (mouseY < height / 11) {
                        if (mouseX > width * 15 / 16) {
                            shopMode = SelectedShopMode.SELL;
                        } else {
                            shopMode = SelectedShopMode.BUY;
                        }
                    } else {
                        Item selectedBuilding = game.items[mouseY / (height / 11) - 1];
                        switch (shopMode) {
                            case BUY -> {
                                if (game.money >= selectedBuilding.price) {
                                    game.money -= selectedBuilding.price;
                                    selectedBuilding.buy();
                                }
                            }
                            case SELL -> {
                                if (selectedBuilding.amount > 0) {
                                    game.money += selectedBuilding.price / 2;
                                    selectedBuilding.sell();
                                }
                            }
                        }
                    }
                }
            }
        }




    }


    public void drawStartScreen() {
        background(255);
        fill(255);
        rect(width / 2 - 100, height / 2 - 75, 200, 100);
        fill(0);
        textSize(70);
        text("Play", width / 2, height / 2);


        fill(255);
        rect(width / 2 + -100, height / 2 + 75, 200, 100);
        fill(0);
        text("Load", width / 2, height / 2 + 150);
    }


    public void drawGame() {
        if (frameCount % 60 == 0) {
            game.money += game.moneyPerSecond;
        }
        game.tick();
        background(255);


        textAlign(LEFT);
        textSize(width / 30);
        if (shopMode == SelectedShopMode.BUY) {
            fill(0);
            rect(width * 7 / 8, 0, width / 16, height / 11);
            fill(255);
            rect(width * 15 / 16, 0, width / 16, height / 11);
            text("Buy", width * 7 / 8 + width / 200, height / 16);
            fill(0);
            text("Sell", width * 15 / 16 + width / 200, height / 16);
        } else {
            fill(255);
            rect(width * 7 / 8, 0, width / 16, height / 11);
            fill(0);
            rect(width * 15 / 16, 0, width / 16, height / 11);
            text("Buy", width * 7 / 8 + width / 200, height / 15);
            fill(255);
            text("Sell", width * 15 / 16 + width / 200, height / 15);
        }
        for (int i = 0; i < game.items.length; i++) {
            drawItemButton(i);
        }


        fill(0);
        textSize(50);
        text("Money Per Second: " + (double) Math.round(game.moneyPerSecond * 100) / 100, 10, height - 15);
        text("Money: " + (double) Math.round(game.money * 100) / 100, 10, height - 85);


        fill(220, 255, 220);
        rect(width / 2 - 100, height / 2 - 40, 200, 80);
        fill(0);
        text("Click Me!", width / 2 - 90, height / 2 + 20);


        fill(200, 200, 255);
        rect(20, 20, width / 10, height / 15);
        fill(0);
        text("Save", width / 35, height / 15);


    }


    public void drawItemButton(int index) {
        switch (shopMode) {
            case BUY -> {
                if (game.items[index].price > game.money) {
                    fill(255, 200, 200);
                } else {
                    fill(200, 255, 200);
                }
            }
            case SELL -> {
                if (game.items[index].amount == 0) {
                    fill(255, 200, 200);
                } else {
                    fill(200, 255, 200);
                }
            }
        }


        rect(7 * width / 8, (1 + index) * height / 11, width / 8, height / 11);
        fill(0);
        textSize(width/45);
        text(game.items[index].name + ": " + game.items[index].amount, 7 * width / 8 + 10, (13 + index * 8) * height / 88);
        textSize(20);
        text("Price: " + game.items[index].price, 7 * width / 8 + width / 200, (10 + index * 8) * height / 88);
        text("Total CPS: " + game.items[index].moneyPerSecond, 7 * width / 8 + width / 200, (15 + index * 8) * height / 88);
    }
}

