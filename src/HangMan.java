import java.util.Random;
public class HangMan {
    String word;
    String[] words = {
            "american",
            "blue",
            "brie",
            "burrata",
            "cheddar",
            "curds",
            "colby",
            "cottage",
            "cream",
            "feta",
            "gouda",
            "limburger",
            "mozzarella",
            "muenster",
            "parmesan",
            "provolone",
            "ricotta",
            "romano",
            "swiss"};
    HangMan() {

    }
    public void run(){
        word = words[Main.random.nextInt(0,words.length)];
        while (true)
    }
}
