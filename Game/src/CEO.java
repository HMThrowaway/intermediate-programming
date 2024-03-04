public class CEO extends Item{
    CEO(int amt){
        amount = amt;
        name = "CEO";
        moneyPerSecond = 50;
        basePrice = 12000;
        price = basePrice * (int) Math.pow(1.1,amount);
    }
}
