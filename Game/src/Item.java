public abstract class Item {
    int amount = 0;
    double moneyPerSecond;
    String name;
    long basePrice;
    long price = basePrice;

    void upgrade(double multiplier){
        moneyPerSecond *= multiplier;
    }
    void downgrade(double multiplier){
        moneyPerSecond /= multiplier;
    }
    void buy(int amt){
        amount+=amt;
        price = basePrice * (int) Math.pow(1.1,amount);
    }
    void sell(int amt){
        amount-=amt;
        price = basePrice * (int) Math.pow(1.1,amount);
    }
    int getTotalMoneyPerSecond(){
        return (int) (moneyPerSecond*amount);
    }
}
