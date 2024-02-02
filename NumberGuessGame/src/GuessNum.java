//This is the code of John Hurd

//Imports
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class GuessNum {
	//Variables
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int guessNum;
    static int num;
    static int maxNum;
    static String AItype;
    static String input;
    static ArrayList<Integer> guesses;
    static NumberGuessAI player;

    GuessNum (String t){
        AItype = t;
        guesses = new ArrayList<>();
        guessNum = 1;
        if (AItype.equalsIgnoreCase("Human")){
            doGameHuman();
        }
        else {
            doGameAI();
        }
    }
    public void doGameAI(){
        player = new NumberGuessAI(AItype, maxNum);
    }
    public void doGameHuman(){//Does the game once the variables have been gotten
        System.out.println("Enter the maximum number (game will begin once you enter a valid response)");
        while (true){
            try {
                maxNum = Integer.parseInt(scanner.nextLine());
                if (maxNum > 0){
                    break;
                }
                else {
                    System.out.println("Please enter a positive integer");
                }

            } catch (NumberFormatException e){
                System.out.println("Please enter a positive integer");
            }

        }
        num = random.nextInt(maxNum)+1;
        System.out.println("See if you can guess it in fewer than 10 guesses");

        int guess;
        System.out.println("Guess a number between 1 and "+maxNum);
        while (true){
            try{
                 guess = Integer.parseInt(scanner.next());
                //check if number is too high too low or just right

                guesses.add(guess);
                int higherOrLower = checkGuess(guess);
                if (higherOrLower == 1){
                    System.out.println("Too High!");
                }
                else if (higherOrLower == -1){
                    System.out.println("Too Low!");

                }
                else {
                    break;
                }
                guessNum += 1;
            }
            catch (NumberFormatException e){
                System.out.println("Please enter an integer");
            }
        }
        finish();
    }
    static int checkGuess(int guess){
        if (guess>num){
            return 1;
        }
        else if (guess < num){
            return -1;
        }
        return 0;
    }
    static void finish(){
        System.out.println("The player guessed the number in "+ guessNum +" guesses!");
        System.out.println("The guesses were:");
        for (int i = 0; i < guesses.size(); i++){
            System.out.println(guesses.get(i));
        }
    }
}
