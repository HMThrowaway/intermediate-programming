import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String response1;
        String response2;

        System.out.println("What is your name?");
        response1 = scanner.nextLine();
        System.out.println("What is your favorite flavor of ice cream?");
        response2 = scanner.nextLine();


        if(response1.equals( "John")){
            System.out.println("HEY THATS MY NAME");
        }
        else {
            System.out.println("Hello "+response1);
        }
        if(response2.equals("Vanilla")){
            System.out.println("HEY THATS MY FLAVOR");
        }
        else {
            System.out.println("Eww I hate "+response2);
        }
    }
}