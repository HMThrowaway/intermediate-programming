//This is the code of John Hurd

//Imports
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class HangMan {
    //Variables
    Random random = new Random();
    static String word;
    char[] letters;
    static boolean[] lettersGuessed;
    String guessString;
    static boolean wordGuessed;
    char guessChar;
    static boolean letterIn;
    static int guessNum = 1;

    HangMan(String p){
        try (Stream<String> lines = Files.lines(Paths.get("src/words.txt"))) {
            word = lines.skip(random.nextInt(2315)).findFirst().get();
        } catch (Exception ignored) {}

        if (Objects.equals(p, "Human")){
            runHumanPlayer();
        }
        else {
            runAIPlayer();
        }
    }
    public void runAIPlayer(){
        String AIType = "";
        while (AIType.isEmpty()){
            Scanner sc = new Scanner(System.in);
            System.out.println("What type of AI should the AI run?");
            String input = sc.nextLine();
            if (input.equals("Smart")||input.equals("Random")){
                AIType = input;
            }
        }
        HangManAI player = new HangManAI(AIType);



    }
    public void runHumanPlayer(){
        System.out.println("Guess the word!");
        letters = word.toCharArray();
        lettersGuessed = new boolean[word.length()];
        for (int i = 0; i < word.length();i++){
            lettersGuessed[i] = false;
        }

        while (true){
            letterIn = false;
            for (int i = 0; i < word.length(); i ++){
                if (lettersGuessed[i]){System.out.print(Character.toUpperCase(word.charAt(i))+" ");}
                else {System.out.print("_ ");}
            }

            System.out.println("\nEnter the letter you are guessing");

            guessString = Main.scanner.nextLine();

        }

    }
    static boolean guess(String s){//returns true if word is guessed
        if (s.length() == 1){
            char c = s.charAt(0);
            for (int i = 0; i <= word.length()-1; i++){
                if(c == word.charAt(i)){
                    lettersGuessed[i] = true;
                    letterIn = true;
                }
            }
        }
        else if (s.equals(word)) {
            return true;
        }
        else {
            System.out.println("Wrong word");
        }

        if (!letterIn){
            System.out.println("There was none of that letter in the word");
        }

        wordGuessed = true;
        for (int i = 0; i < word.length(); i ++){
            if (!lettersGuessed[i]){
                wordGuessed = false;
            }
        }

        if (wordGuessed){
            return true;
        } else {
            guessNum += 1;
        }

        return false;
    }
    static void finish(){
        System.out.println("You guessed the word in "+guessNum+ " guesses!");
    }
}
