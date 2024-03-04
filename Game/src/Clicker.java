public class Clicker extends Item{
    Clicker(int amt){
        amount = amt;
        name = "Clicker";
        moneyPerSecond = 0.1;
        basePrice = 15;
        price = basePrice * (int) Math.pow(1.1,amount);
    }
}
