package discount;

public class NoDiscount implements Discount {

    @Override
    public int new_price(int price) {
        return price;
    }
}
