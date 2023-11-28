import java.util.Random;
import java.util.Scanner;
public class GuessNum {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int guessNum = 1;
    static int num;
    static int maxNum;
    static String input;
    public void run()  {
        System.out.println("Enter your maximum number (game will begin once you enter a valid response)");
        maxNum = getNum();
        num = random.nextInt(maxNum)+1;
        System.out.println("See if you can guess it in fewer than " + Main.guessNumHighScore + " guesses");
        System.out.println("You guessed the number in "+doGame()+" guesses!");
        if (guessNum < Main.guessNumHighScore){
            Main.guessNumHighScore = guessNum;
        }
    }
    public int getNum(){//Gets maximum number
        input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            return getNum();
        }
    }
    public int doGame(){//Runs game
        int guess;
        System.out.println("Guess a number between 1 and "+maxNum);
        while (true){
            try {
                guess = Integer.parseInt(scanner.nextLine());
                if (guess == num){
                    return guessNum;
                }
                else if (guess > num){
                    System.out.println("Too High!");
                }
                else if (guess < num){
                    System.out.println("Too Low!");
                }
                guessNum += 1;
            }
            catch (Exception e){
                System.out.println("Please enter an integer");
            }
            //check if number is too high too low or just right
        }
    }
}
