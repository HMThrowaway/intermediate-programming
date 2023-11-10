import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int guessNum;
    static int num;
    static int maxNum;
    public void main() {
        maxNum = this.getNum();
        num = random.nextInt(maxNum)+1;
        System.out.println("You guessed the number in "+doGame()+" guesses!");
    }
    public int getNum(){
        while (true){
            System.out.println("Enter your maximum number!");
            String num = scanner.nextLine();
            boolean numeric = true;
            try {
                return Integer.parseInt(num);
            } catch (NumberFormatException e) {
                numeric = false;
            }
            if (numeric = false){
                System.out.println("Please enter a number");
            }
        }
    }
    public int doGame(){
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
