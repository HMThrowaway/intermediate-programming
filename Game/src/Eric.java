public class Eric extends Item{
    Eric(int amt){
        amount = amt;
        name = "Eric";
        moneyPerSecond = 275000;
        basePrice = 5100000000L;
        price = basePrice * (int) Math.pow(1.1,amount);
    }
}
