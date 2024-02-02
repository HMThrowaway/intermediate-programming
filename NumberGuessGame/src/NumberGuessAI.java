import java.util.Random;

public class NumberGuessAI {
    private final Random random = new Random();
    private final String strategy;
    private int min = 0;
    private int max;
    private int guessNum = 1;

    NumberGuessAI(String strategy, int max){
        this.strategy = strategy;
        this.max = max;
        go();
    }
    void go(){
        boolean temp = true;

        while (temp){
            int guess = guess();
            GuessNum.guesses.add(guess);

            switch (GuessNum.checkGuess(guess)){
                case 1 -> {
                    min = guess;
                }
                case -1 -> {
                    max = guess;
                }
                case 0 -> {
                    GuessNum.finish();
                    temp = false;
                }
            }
            guessNum++;
        }
    }
    int guess(){
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
    void finish(){
        GuessNum.finish();
    }
}
