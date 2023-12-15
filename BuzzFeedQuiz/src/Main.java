import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Question> questions = new ArrayList<>();
    static int[] scores = new int[4];
    static boolean tie = false;
    static ArrayList<Integer> numsInTie = new ArrayList<>();
    static final String[] answers = {
            "Default",
            "Omega",
            "Peely",
            "Fishstick"
    };
    static Question tbq = new Question("What was you favorite way to get loot?", "Chest", "Supply Drop", "Loot Llama", "Vending Machine");
    public static void main(String[] args) {
        System.out.println("What fortnite skin are you?\n");

        questions.add(new Question("What was your favorite OG drop spot?", "Junk Junction", "Tilted Towers", "The Volcano", "Salty Springs"));
        questions.add(new Question("What was your favorite OG gun?", "Pistol", "Pump", "Boom Bow", "Double Barrel"));
        questions.add(new Question("What was your favorite OG season?", "Season 1", "Season 4", "Season 8", "Season 7"));
        questions.add(new Question("What was your favorite OG live event?", "The Rocket Launch", "Meteor Event", "Volcano Eruption", "Kevin The Cube"));
        questions.add(new Question("What was your favorite OG heals?", "Med Kit", "Minis", "Chug Splashes", "Chug Jug"));
        questions.add(new Question("What was your favorite OG vehicle?", "Golf Cart", "Quad Crashers", "Ballers", "Planes"));
        questions.add(new Question("What was your favorite OG movement item?", "Impulse Grenades", "Grappler", "Flintknock Pistol", "Launch Pads"));
        questions.add(new Question("What was your favorite OG grenade?","Grenade","Air Strike","Boogie Bomb","CLingers"));

        for (int i = 0; i < 8; i++){
            questions.get(i).ask();
            checkUserInput(i);
        }
        checkAnswer();

    }
    static int checkUserInput(int i){
        switch (questions.get(i).ask().toUpperCase()){
            case "A" -> {
                Main.scores[0] += 1;
                return 0;
            }
            case "B" -> {
                Main.scores[1] += 1;
                return 1;
            }
            case "C" -> {
                Main.scores[2] += 1;
                return 2;
            }
            case "D" -> {
                Main.scores[3] += 1;
                return 3;
            }
        }
        System.out.println("Please enter a valid response");
        checkUserInput(i);
        return checkUserInput(i);
    }
    static void checkAnswer(){
        int max = 0;
        for(int i=0; i<scores.length; i++) {
            if (scores[max] < scores[i]) {
                max = i;
                tie = false;
                numsInTie.clear();
            }
            else if(scores[max]==scores[i]){
                tie = true;
                numsInTie.add(i);
            }
        }
        if (tie){
            int temp = checkUserInput(8);
            if (temp < numsInTie.size()) {
                max = temp;
            }
        }
        System.out.println("You are a "+ answers[max] + " skin");
    }
}