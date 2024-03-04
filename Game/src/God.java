public class God extends Item{
    God(int amt){
        amount = amt;
        name = "God";
        moneyPerSecond = 8300;
        basePrice = 20000000;
        price = basePrice * (int) Math.pow(1.1,amount);
    }
}
