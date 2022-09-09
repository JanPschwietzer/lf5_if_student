package discount;

public class DiscountCalc {
    public int calc(int amount) {


        if (amount > 1000) {
            return (int) (amount * 0.9);
        }
        return amount;
    }
}
