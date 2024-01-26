//This is the code of John Hurd

//Imports
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

public class HangMan {
    //Variables
    Random random = new Random();
    String word;
    char[] letters;
    boolean[] lettersGuessed;
    String guessString;
    boolean wordGuessed;
    char guessChar;
    boolean letterIn;
    int guessNum = 1;


    public void run(){
        try (Stream<String> lines = Files.lines(Paths.get("src/words.txt"))) {
            word = lines.skip(random.nextInt(2315)).findFirst().get();
        } catch (Exception e) {
        }
        System.out.println("Guess the word!");
        letters = word.toCharArray();
        lettersGuessed = new boolean[word.length()];
        for (int i = 0; i < word.length();i++){lettersGuessed[i] = false;}

        while (true){
            letterIn = false;
            for (int i = 0; i < word.length(); i ++){
                if (lettersGuessed[i]){System.out.print(Character.toUpperCase(word.charAt(i))+" ");}
                else {System.out.print("_ ");}
            }

            System.out.println("\nEnter the letter you are guessing");

            guessString = Main.scanner.nextLine();

            if (guessString.length() == 1){
                guessChar = guessString.charAt(0);
                for (int i = 0; i <= word.length()-1; i++){
                    if(guessChar == word.charAt(i)){
                        lettersGuessed[i] = true;
                        letterIn = true;
                    }
                }
            }

            else if (guessString.equals(word)) {
                break;
            }

            else {
                System.out.println("Wrong word");
            }

            wordGuessed = true;
            for (int i = 0; i < word.length(); i ++){
                if (!lettersGuessed[i]){
                    wordGuessed = false;
                }
            }
            if (wordGuessed){
                break;
            }
            else {
                guessNum += 1;
            }
            if (!letterIn){System.out.println("There was none of that letter in the word");}
        }
        System.out.println("You guessed the word in "+guessNum+ " guesses!");
    }
}
