package discount2;

public class Discount {
    public double calcPorto(int amount) {
        if (amount <= 25 && amount > 10) {
            return amount + 5;
        } else if (amount <= 10) {
            return amount + 2;
        } else {
            return amount * 0.95;
        }
    }
}