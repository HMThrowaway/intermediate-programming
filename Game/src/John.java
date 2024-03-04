public class John extends Item{
    John(int amt){
        amount = amt;
        name = "John";
        moneyPerSecond = 1800000;
        basePrice = 75000000000L;
        price = basePrice * (int) Math.pow(1.1,amount);
    }
}
