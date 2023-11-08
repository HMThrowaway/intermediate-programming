
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
public class Main {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int guessNum;
    static int num;
    static int maxNum;
    public static void main(String[] args) {
        maxNum = getNum();
        num = random.nextInt(maxNum)+1;
        System.out.println("You guessed the number in "+doGame()+" guesses!");
    }
    public static int getNum(){
        while (true){
            System.out.println("Enter your maximum number!\n");
            String num = scanner.nextLine();
            boolean numeric = true;
            try {
                return Integer.parseInt(num);
            } catch (NumberFormatException e) {
                numeric = false;
            }
        }
    }
    public static int doGame(){
        int guess = 0;
        while (true){
            System.out.println("Guess a number between 1 and "+maxNum);
            guess = scanner.nextInt();
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
    }
}