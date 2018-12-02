package discount;

public class NewYearDiscount implements Discount {
    @Override
    public int new_price(int price) {
        return (int) (price * 0.8);
    }
}
