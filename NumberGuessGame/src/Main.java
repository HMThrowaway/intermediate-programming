//This is the code of John Hurd

//Import
import java.util.Scanner;
public class Main {
    //Variables
    static Scanner scanner = new Scanner(System.in);
    static String input;
    static int repetitions;
    static boolean gameIsHangman;
    static String playerType;
    static HangMan hangManGame;
    static GuessNum guessNumGame;

    public static void main(String[] args) {
        //Game Selection
        System.out.println("Select your game (\"h\" for hangman or \"n\" for number guess game)");
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("h")){
                gameIsHangman = true;
                break;
            }
            else if (input.equalsIgnoreCase("n")) {
                gameIsHangman = false;
                break;
            }
            else {System.out.println("That isn't a valid answer");}
        }

        System.out.println("Do you or the AI want to play\n\"a\" for AI \"h\" for you");
        input = scanner.nextLine();
        while (true){//How many times the player would like to play the game
            try {
                //This line will throw an exception if the user input couldn't be converted to an int
                if (input.equalsIgnoreCase("A")){
                    playerType = "AI";
                    break;
                }
                else if(input.equalsIgnoreCase("H")){
                    playerType = "Human";
                    break;
                }
                System.out.println("Please enter either \"a\" or \"h\"");
                input = scanner.nextLine();
            }
            catch (Exception e){
                System.out.println("Please enter either \"a\" or \"h\"");
                input = scanner.nextLine();
            }
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


        String AIType = "";
        if (!playerType.equals("Human") && gameIsHangman) {
            System.out.println("What type of AI should the AI run?");
            System.out.println("Types: Smart, Random, and Einstein");
            while (AIType.isEmpty()) {
                Scanner sc = new Scanner(System.in);

                String input = sc.nextLine();
                if (input.equalsIgnoreCase("Smart") || input.equalsIgnoreCase("Random") || input.equalsIgnoreCase("Einstein")) {
                    AIType = input;
                }
                else {
                    System.out.println("That isn't a valid response");
                }
            }
        }
        if (!playerType.equals("Human") && !gameIsHangman) {
            System.out.println("What type of AI should the AI run?");
            System.out.println("Types: Half, Random, and Linear");
            while (true) {
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("Random") || input.equalsIgnoreCase("Half") || input.equalsIgnoreCase("Linear")) {
                    playerType = input;
                    break;
                }
                else {
                    System.out.println("That isn't a valid response");
                }
            }
        }
        int maxNum = 0;
        if (!gameIsHangman){
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
        }

        //System.out.println("Num: "+ maxNum);
        for (int i = 1; i <repetitions+1; i++){
            System.out.println("\nGame "+i+" out of "+repetitions);
            if (gameIsHangman){
                hangManGame = new HangMan(playerType);
            } //runs hangman
            else {
                guessNumGame = new GuessNum(playerType,maxNum);
            } //runs number guessing game
        }

        if (!gameIsHangman){
            System.out.println("Guess counts: ");
            for (int i = 0; i < maxNum; i++){
                System.out.println(GuessNum.guessCounts.get(i));
            }
        }
    }
}