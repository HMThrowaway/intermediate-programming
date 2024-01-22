import java.util.Random;

public class NumberGuessAI {
    Random random = new Random();
    int min;
    int max;
    String strategy;
    NumberGuessAI(String strategy){

    }
    int guess(String strategy, int min, int max){
        int guess = 0;
        switch (strategy){
            case "Random" -> {
                guess = random.nextInt(min,max);
            }
        }
        return guess;
    }
}
