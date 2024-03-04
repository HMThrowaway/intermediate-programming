public abstract class Item {
    int amount;
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
    void buy(){
        amount++;
        price = (long) (basePrice * Math.pow(1.1,amount));
    }
    void sell(){
        amount--;
        price = (long) (basePrice * Math.pow(1.1,amount));
    }
    double getTotalMoneyPerSecond(){
        return moneyPerSecond*amount;
    }
}
