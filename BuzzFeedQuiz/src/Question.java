import java.util.Scanner;

public class Question {
    Scanner scanner = new Scanner(System.in);
    String question;
    String a1;
    String a2;
    String a3;
    String a4;
    String input;
    Question(String question,String a1, String a2,String a3,String a4){
        this.question = question;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.ask();
    }
    void ask(){
        System.out.println(question);
        System.out.println("A: "+a1);
        System.out.println("B: "+a2);
        System.out.println("C: "+a3);
        System.out.println("D: "+a4);
        input = scanner.next();
        this.checkAnswer();

    }
    void checkAnswer(){
        input = input.toUpperCase();
        switch (input){
            case "A" -> {
                Main.scores[0] += 1;
                return;
            }
            case "B" -> {
                Main.scores[1] += 1;
                return;
            }
            case "C" -> {
                Main.scores[2] += 1;
                return;
            }
            case "D" -> {
                Main.scores[3] += 1;
                return;
            }
        }
        System.out.println("Please enter a valid response");
        this.ask();
    }
}
