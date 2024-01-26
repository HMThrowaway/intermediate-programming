import java.util.Random;

public class NumberGuessAI {
    Random random = new Random();
    int min;
    int max;
    String strategy;
    NumberGuessAI(String strategy){
        this.strategy = strategy;
    }
    int guess(String strategy, int min, int max){
        int guess = 0;
        switch (strategy){
            case "Random" -> {
                guess = random.nextInt(max-min)+min;
            }
            case "Half" -> {
                guess = (min+max)/2;
            }
            case "Linear" -> {
                guess = min+1;
            }
        }
        return guess;
    }
}
