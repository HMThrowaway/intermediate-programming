//Code of John Hurd
//Imports
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    //Variables

    static ArrayList<Question> questions = new ArrayList<>(); //Keeps track of all questions
    static int[] scores = new int[4]; //Keeps track of how many times the user has entered each number
    static ArrayList<Integer> mostAnswered = new ArrayList<>();
    static final String[] answers = {"Default", "Omega", "Peely", "Fishstick"};//All Possible answers
        public static void main(String[] args) {
            System.out.println("What fortnite skin are you?\n");

            //Adds questions into arrayList
            questions.add(new Question("What was your favorite OG drop spot?", "Junk Junction", "Tilted Towers", "The Volcano", "Salty Springs"));
            questions.add(new Question("What was your favorite OG gun?", "Pistol", "Pump", "Boom Bow", "Double Barrel"));
            questions.add(new Question("What was your favorite OG season?", "Season 1", "Season 4", "Season 8", "Season 7"));
            questions.add(new Question("What was your favorite OG live event?", "The Rocket Launch", "Meteor Event", "Volcano Eruption", "Kevin The Cube"));
            questions.add(new Question("What was your favorite OG heals?", "Med Kit", "Minis", "Chug Splashes", "Chug Jug"));
            questions.add(new Question("What was your favorite OG vehicle?", "Golf Cart", "Quad Crashers", "Ballers", "Planes"));
            questions.add(new Question("What was your favorite OG movement item?", "Impulse Grenades", "Grappler", "Flintknock Pistol", "Launch Pads"));
            questions.add(new Question("What was your favorite OG grenade?","Grenade","Air Strike","Boogie Bomb","CLingers"));
            questions.add(new Question("What was your favorite way to get loot?", "Chest", "Supply Drop", "Llama", "Vending Machine"));
            //Randomizes Questions
            Collections.shuffle(questions);
            for (int i = 0; i < 8; i++){
                //Question Loop
                checkUserInput(i);
            }
            checkAnswer();
        }
    static int checkUserInput(int i){
        //Checks user's answer
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
        return checkUserInput(i);
    }
    static void checkAnswer(){
        //Checks which letter the user has entered the most
        int max = 0;
        for(int i=0; i<scores.length; i++) {
            if (scores[max] < scores[i]) {
                max = i;
                mostAnswered.clear();
                mostAnswered.add(i);
            }
            else if(scores[max]==scores[i]){
                mostAnswered.add(i);
            }
        }

        //Checks for tie
        if (mostAnswered.size() != 1){
            int temp = checkUserInput(8);
            if (temp < mostAnswered.size()) {
                max = temp;
            }
        }
        System.out.println("You are a "+ answers[max] + " skin");
    }
}