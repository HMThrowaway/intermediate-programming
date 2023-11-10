import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String input;
    public static void main(String[] args) {
        while (true) {
            System.out.println("Would you like to play hangman or number guess");
            System.out.println("(\"h\" for hangman or \"n\" for number guess game)");
            input = scanner.nextLine();
            if (input.equals("h")||input.equals("H")){
                playHangMan();
                break;
            }
            else if (input.equals("n")|| input.equals("N")) {
                playNumberGuessingGame();
                break;
            }
            else {
                System.out.println("That isn't a valid answer");
            }
        }
    }
    public static void playHangMan(){
        HangMan game = new HangMan();
        game.run();
    }
    public static void playNumberGuessingGame(){
        GuessNum game = new GuessNum();
        game.main();
    }
}