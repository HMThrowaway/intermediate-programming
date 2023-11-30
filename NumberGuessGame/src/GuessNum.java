//This is the code of John Hurd

//Imports
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class GuessNum {
	//Variables
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int guessNum = 1;
    static int num;
    static int maxNum;
    static String input;
    static ArrayList<Integer> guesses = new ArrayList<>();
    public void run()  {//Runs the game
        System.out.println("Enter your maximum number (game will begin once you enter a valid response)");
        maxNum = getNum();
        num = random.nextInt(maxNum)+1;
        System.out.println("See if you can guess it in fewer than 10 guesses");
        System.out.println("You guessed the number in "+doGame()+" guesses!");
        System.out.println("Your guesses were:");
        for (int i = 0; i < guesses.size(); i++){
            System.out.println(guesses.get(i));
        }
    }
    public int getNum(){//Gets maximum number
        input = scanner.nextLine();
        try {return Integer.parseInt(input);}
        catch (NumberFormatException e) {return getNum();}
    }
    public int doGame(){//Does the game once the variables have been gotten
        int guess;
        System.out.println("Guess a number between 1 and "+maxNum);
        while (true){
            try{
                 guess = Integer.parseInt(scanner.next());
                 if (guesses.contains(guess)){
                     System.out.println("You already guessed that");
                 }
                 else {
                     //check if number is too high too low or just right
                     guesses.add(guess);
                     if (guess == num) {
                         return guessNum;
                     } else if (guess > num) {
                         System.out.println("Too High!");
                     } else if (guess < num) {
                         System.out.println("Too Low!");
                     }
                     guessNum += 1;
                 }
            }
            catch (NumberFormatException e){
                System.out.println("Please enter an integer");
            }
        }
    }
}
