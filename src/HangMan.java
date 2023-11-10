public class HangMan {
    String word;
    char[] letters;
    boolean[] lettersGuessed;
    String guessString;
    boolean wordGuessed;
    char guessChar;
    int guessNum = 0;
    String[] words = {
            "american",
            "blue",
            "brie",
            "burrata",
            "cheddar",
            "curds",
            "colby",
            "cottage",
            "cream",
            "feta",
            "gouda",
            "limburger",
            "mozzarella",
            "muenster",
            "parmesan",
            "provolone",
            "ricotta",
            "romano",
            "swiss"};
    HangMan() {

    }
    public void run(){
        System.out.println("Guess the cheese!");
        word = words[Main.random.nextInt(0,words.length)];
        System.out.println(word);
        letters = word.toCharArray();
        lettersGuessed = new boolean[word.length()];
        for (int i = 0; i < word.length();i++){
            lettersGuessed[i] = false;
        }

        while (true){
            for (int i = 0; i < word.length(); i ++){
                if (lettersGuessed[i]){
                    System.out.print(word.charAt(i)+" ");
                }
                else {
                    System.out.print("_ ");
                }
            }
            System.out.println("\nEnter the letter you are guessing");
            guessString = Main.scanner.nextLine();
            if (guessString.length() == 1){
                guessChar = guessString.charAt(0);
                for (int i = 0; i <= word.length()-1; i++){
                    if(guessChar == word.charAt(i)){
                        lettersGuessed[i] = true;
                    }
                }
            }
            else if (guessString.equals(word)) {
                System.out.println("Wow, you guessed it!");
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
        }
        System.out.println("You guessed the word");
    }
}
