//This is the code of John Hurd

//Imports
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    //Variables
    static Scanner scanner = new Scanner(System.in);
    static String input;
    static int repetitions;
    static boolean gameIsHangman;


    public static void main(String[] args) {
        //Game Selection
        System.out.println("Would you like to play hangman or number guess");
        System.out.println("(\"h\" for hangman or \"n\" for number guess game)");
        while (true) {
            input = scanner.nextLine();
            if (input.equals("h")||input.equals("H")){
                gameIsHangman = true;
                break;
            }
            else if (input.equals("n")|| input.equals("N")) {
                gameIsHangman = false;
                break;
            }
            else {System.out.println("That isn't a valid answer");}
        }

        System.out.println("How many times would you like to play this game?");
        while (true){//How many times the player would like to play the game
            input = scanner.nextLine();
            try {
                //This line will throw an exception if the user input couldn't be converted to an int
                repetitions = Integer.parseInt(input);
                if (repetitions < 1){throw new Exception();}//if the number that the user entered was less than 0, this line will throw an exception, resetting the loop
                for (int i = 1; i <repetitions+1; i++){
                    System.out.println("\nGame "+i+" out of "+repetitions);
                    if (gameIsHangman){new HangMan().run();} //runs hangman
                    else {new GuessNum().run();} //runs number guessing game
                }
                break;
            }
            catch (Exception e){System.out.println("Please enter an integer greater than 0");}
        }
    }
}