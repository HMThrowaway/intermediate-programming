public class Main {
    static int[] scores = new int[4];
    static final String[] answers = {
            "Default",
            "Omega",
            "Peely",
            "Fishstick"
    };
    public static void main(String[] args) {
        System.out.println("What fortnite skin are you?\n");

        new Question("What was your favorite drop spot?","Junk Junction","Tilted Towers","The Volcano","Salty Springs");
        new Question("What was your favorite OG gun","Pistol","Pump","Boom Bow","Double Barrel");
        new Question("What was your favorite season","Season 1","Season 4","Season 8","Season 7");
        new Question("What was your favorite live event","The Rocket Launch","Meteor Event","Volcano Eruption","Marshmello Concert");
        new Question("What was your favorite OG heals","Med Kit","Minis","Chug Splashes","Chug Jug");

        checkAnswer();
    }
    static void checkAnswer(){
        int max = 0;
        for(int i=0; i<scores.length; i++) {
            if (scores[max] < scores[i]) {
                max = i;
            }
        }
        System.out.println("You are a "+ answers[max] + " skin");
    }
}