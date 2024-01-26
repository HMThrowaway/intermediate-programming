import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

public class HangManAI {
    HashMap<Character,Integer> letterScores = new HashMap<>();
    FileWriter fileWriter;
    String type;
    String alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
    String lettersGuessed;

    {
        try {
            this.fileWriter = new FileWriter("src/HangManAIData.txt");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    HangManAI(String t) {
        type = t;

        for (int i = 0; i < 26; i++){
            int temp;
            try (Stream<String> lines = Files.lines(Paths.get("src/HangManAIData.txt"))) {
                temp = Integer.parseInt(lines.skip(i).findFirst().get());
            } catch (Exception e) {
                temp = 0;
                try {
                    fileWriter.write("0\n");
                }
                catch (Exception ex){}
            }
            letterScores.put(alphabet.charAt(i),temp);
        }
        try {
            fileWriter.close();
        }
        catch (IOException e){
            System.out.println("FileWriter couldn't close!");
        }
        //FileWriter Stuff Done




    }
    char guess(){
        char guess = 'A';
        switch (type){
            case "Random" ->{
                guess = alphabet.charAt(
                        new Random()
                                .nextInt(25)
                );
            }
            case "Smart" -> {
                int highScore = 0;

                for (Map.Entry<Character, Integer> entry : letterScores.entrySet()){
                    char key = entry.getKey();
                    int value = entry.getValue();
                    if (key>highScore){
                        highScore = key;
                        guess = key;
                    }
                }
            }
            case "" -> {

            }
        }
        return guess;
    }
}
