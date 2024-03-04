public class Lucas extends Item{
    Lucas(int amt){
        amount = amt;
        name = "Lucas";
        moneyPerSecond = 49000;
        basePrice = 330000000;
        price = basePrice * (int) Math.pow(1.1,amount);
    }
}
