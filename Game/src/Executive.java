public class Executive extends Item{
    Executive(int amt){
        amount = amt;
        name = "Executive";
        moneyPerSecond = 10;
        basePrice = 1100;
        price = basePrice * (int) Math.pow(1.1,amount);
    }
}
