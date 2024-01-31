import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class HangManAI {
    HashMap<Character,Integer> letterScores = new HashMap<>();
    ;
    String type;
    final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    ArrayList<String> possibleWords = new ArrayList<>();

    HangManAI(String t){
        type = t;

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("src/HangManAIData.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 26; i++) {
            //TODO Add code for writing to file
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //FileWriter Stuff Done


    }
    char guess(){
        char guess = 'A';
        switch (type){
            case "Random" ->{
                guess = alphabet.charAt(new Random().nextInt(25));
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
                //TODO Finish Smart code
            }
            case "Einstein" -> {
                for (int i = 0; i < 2314; i++){
                    try (Stream<String> lines = Files.lines(Paths.get("src/HangManAIData.txt"))) {
                        possibleWords.add(lines.skip(i).findFirst().get());
                    } catch (Exception ignored) {}
                }
                //TODO Finish Eintsein Code
            }
        }
        return guess;
    }
}
