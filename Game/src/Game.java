import java.io.*;
import java.util.Scanner;


public class Game {
    Item[] items;
    double moneyPerSecond;
    double money;
    double moneyPerClick;
    Game(String fileName){
        getSaveData(fileName);
        moneyPerSecond = getMoneyPerSecond();
    }
    Game(){
        items = new Item[]{
                new Clicker(0),
                new Worker(0),
                new Executive(0),
                new CEO(0),
                new JoeBiden(0),
                new TheRock(0),
                new God(0),
                new Lucas(0),
                new Eric(0),
                new John(0)};
        moneyPerSecond = 0;
    }
    void getSaveData(String fileName){
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            items = new Item[]{
                    new Clicker(reader.nextInt()),
                    new Worker(reader.nextInt()),
                    new Executive(reader.nextInt()),
                    new CEO(reader.nextInt()),
                    new JoeBiden(reader.nextInt()),
                    new TheRock(reader.nextInt()),
                    new God(reader.nextInt()),
                    new Lucas(reader.nextInt()),
                    new Eric(reader.nextInt()),
                    new John(reader.nextInt())};
            moneyPerSecond = getMoneyPerSecond();
            money = reader.nextInt();
            reader.close();
        } catch (FileNotFoundException e) {System.out.println("This save file couldn't be located");}
    }
    double getMoneyPerSecond(){
        double totalMoney = 0;
        for (int i = 0; i < 10; i++){
            totalMoney += items[i].getTotalMoneyPerSecond();
        }
        return totalMoney;
    }
    void buttonClicked(){
        money+=moneyPerClick;
    }
    void tick(){
        moneyPerSecond = getMoneyPerSecond();
        moneyPerClick = moneyPerSecond/10 + 1;
    }
    void save(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Save.txt"));
            for (Item item: items){
                writer.write(item.amount+ "\n");
            }
            writer.write((int) money+"\n");
            writer.close();
        }
        catch (IOException ignored){


        }
    }
}

