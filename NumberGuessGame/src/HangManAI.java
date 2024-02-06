import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class HangManAI {
    HashMap<String,Integer[]> letterScores = new HashMap<>();
    HangMan game = Main.hangManGame;
    String type;
    final String alphabet = "abcdefghijklmnopqrstuvwxyz";


    ArrayList<String> possibleWords = new ArrayList<>();

    HangManAI(String t){
        type = t;
        File file = new File("src/HangManAIData.txt");
        Scanner fileReader;
        try {
            fileReader = new Scanner(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 26; i++) {
            try {
                letterScores.put(String.valueOf(alphabet.charAt(i)), new Integer[]{fileReader.nextInt(), fileReader.nextInt()});
            }
            catch (Exception ignored){}
        }
        //FileWriter Stuff Done


    }
    String guess(){
        String guess = "a";
        switch (type){
            case "Random" ->{
                guess = String.valueOf(alphabet.charAt(new Random().nextInt(25)));
            }
            case "Smart" -> {
                int highScore = 0;

                for (Map.Entry<String, Integer[]> entry : letterScores.entrySet()){
                    String key = entry.getKey();
                    int value = entry.getValue()[0]/entry.getValue()[1];
                    if (value>highScore){
                        highScore = value;
                        guess = key;
                    }
                }
                System.out.println(guess);
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
    void close(){
        try {
            FileWriter writer = new FileWriter("src/HangManAIData.txt");
            for (int i = 0; i < 26; i++){
                writer.write(letterScores.get(String.valueOf(alphabet.charAt(i)))[0]+ " " + letterScores.get(String.valueOf(alphabet.charAt(i)))[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
