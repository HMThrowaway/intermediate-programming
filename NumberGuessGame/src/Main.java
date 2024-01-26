//This is the code of John Hurd

//Imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    //Variables
    static Scanner scanner = new Scanner(System.in);
    static String input;
    static int repetitions;
    static boolean gameIsHangman;
    static boolean playerIsHuman;
    static HangManAI temp = new HangManAI("Random");

    public static void main(String[] args) {
        //Game Selection
        System.out.println("Select your game");
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

        System.out.println("Do you or the AI want to play\n\"a\" for AI \"h\" for you");
        while (true){//How many times the player would like to play the game
            input = scanner.nextLine();
            try {
                //This line will throw an exception if the user input couldn't be converted to an int
                if (input.equalsIgnoreCase("A")){
                    playerIsHuman = false;
                }
                else if(input.equalsIgnoreCase("H")){
                    playerIsHuman = true;
                }
                break;
            }
            catch (Exception e){System.out.println("Please enter either \"a\" or \"h\"");}
        }

        System.out.println("How many times should the player play this game?");
        while (true){//How many times the player would like to play the game
            input = scanner.nextLine();
            try {
                //This line will throw an exception if the user input couldn't be converted to an int
                repetitions = Integer.parseInt(input);
                if (repetitions < 1){throw new Exception();}//if the number that the user entered was less than 0, this line will throw an exception, resetting the loop

                break;
            }
            catch (Exception e){System.out.println("Please enter an integer greater than 0");}
        }
        for (int i = 1; i <repetitions+1; i++){
            System.out.println("\nGame "+i+" out of "+repetitions);
            if (gameIsHangman){new HangMan().run();} //runs hangman
            else {new GuessNum().run();} //runs number guessing game
        }
    }
}