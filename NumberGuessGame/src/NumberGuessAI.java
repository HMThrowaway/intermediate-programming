import java.util.Random;

public class NumberGuessAI {
    private final Random random = new Random();
    private final String strategy;
    private int min = 1;
    private int max;

    NumberGuessAI(String strategy, int max){
        this.strategy = strategy;
        this.max = max;
        go();
    }
    void go(){

        while (min +2 <= max ){
            int guess = guess();
            //System.out.println(min + " "+ guess + " "+ max);
            GuessNum.guesses.add(guess);
            switch (GuessNum.checkGuess(guess)){
                case "Higher" -> {
                    //System.out.println("H " + guess + " "+ min);
                    min = guess;
                }
                case "Lower" -> {
                    //System.out.println("l " + guess + " "+ max);
                    max = guess;
                }
                case "Equal" -> {
                    GuessNum.finish();
                    min = guess;
                    max = guess;

                }
            }
            GuessNum.guessNum++;
            //System.out.println(GuessNum.guessNum);
        }
    }
    int guess(){
        int guess = 0;

        switch (strategy.toUpperCase()){
            case "RANDOM" -> {
                guess = random.nextInt(max-min)+min;
            }
            case "HALF" -> {
                guess = (min+max)/2;
            }
            case "LINEAR" -> {
                guess = min+1;
            }
        }
        return guess;
    }
}
