public class Worker extends Item{
    Worker(int amt){
        amount = amt;
        name = "Worker";
        moneyPerSecond = 0.1;
        basePrice = 100;
        price = basePrice * (int) Math.pow(1.1,amount);
    }
}
