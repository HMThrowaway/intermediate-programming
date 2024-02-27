import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
    Item[] items = {
        new Clicker(),
        new Worker(),
        new Executive(),
        new CEO(),
        new JoeBiden(),
        new TheRock(),
        new God(),
        new Lucas(),
        new Eric(),
        new John()};


    int moneyPerSecond;
    Game(String fileName){
        getSaveData(fileName);
    }
    Game(){
        moneyPerSecond = 0;
    }
    void getSaveData(String fileName){
        try {
            File file = new File("Saves/"+fileName);
            String data;
            Scanner reader = new Scanner(file);
            for (int i = 0; i<10; i++){

            }
            reader.close();
        } catch (FileNotFoundException e) {System.out.println("This save file couldn't be located");}
    }
    int getMoneyPerSecond(){
        for (int i = 0; i < 10; i++){

        }
    }
}
