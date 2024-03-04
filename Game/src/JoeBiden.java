public class JoeBiden extends Item{
    JoeBiden(int amt){
        amount = amt;
        name = "Joe Biden";
        moneyPerSecond = 275;
        basePrice = 130000;
        price = basePrice * (int) Math.pow(1.1,amount);
    }
}
