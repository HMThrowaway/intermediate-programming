//This is the code of John Hurd

//Imports
import java.util.ArrayList;
import java.util.HashMap;
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
    static ArrayList<Integer> guesses;
    static NumberGuessAI player;


    GuessNum (String t, int max){
        AItype = t;
        guesses = new ArrayList<>();
        guessNum = 1;
        maxNum = max;



        num = random.nextInt(maxNum)+1;
        if (AItype.equalsIgnoreCase("Human")){
            doGameHuman();
        }
        else {
            doGameAI();
        }
    }
    public void doGameAI(){
        player = new NumberGuessAI(AItype, maxNum);
        System.out.println("Number: " + num);
    }
    public void doGameHuman(){//Does the game once the variables have been gotten

        System.out.println("See if you can guess it in fewer than 10 guesses");

        int guess;
        System.out.println("Guess a number between 1 and "+maxNum);
        while (true){
            try{
                 guess = Integer.parseInt(scanner.next());
                //check if number is too high too low or just right

                guesses.add(guess);
                String higherOrLower = checkGuess(guess);
                if (higherOrLower.equals("Higher")){
                    System.out.println("Too High!");
                }
                else if (higherOrLower.equals("Lower")){
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
        System.out.println("The guesses were:");
        for (int i = 0; i < guesses.size(); i++){
            System.out.println(guesses.get(i));
            System.out.println(Main.guessCounts.get(i));
        }
        finish();
    }
    static String checkGuess(int guess){
        if (guess>num){
            return "Lower";
        }
        else if (guess < num){
            return "Higher";
        }
        return "Equal";
    }
    static void finish(){
        System.out.println("The player guessed the number in "+ guessNum +" guesses!");
        
        for (Integer guess : guesses) {
            Main.guessCounts.put(guess-1, Main.guessCounts.get(guess-1) + 1);
        }
        Main.avg += 

    }
}
