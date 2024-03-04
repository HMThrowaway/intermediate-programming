public class TheRock extends Item{
    TheRock(int amt){
        amount = amt;
        name = "The Rock";
        moneyPerSecond = 1500;
        basePrice = 1400000;
        price = basePrice * (int) Math.pow(1.1,amount);
    }
}
