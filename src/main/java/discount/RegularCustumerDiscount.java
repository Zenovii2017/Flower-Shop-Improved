package discount;

public class RegularCustumerDiscount implements Discount{
    @Override
    public int new_price(int price){
        return (int)(price * 0.75);
    }
}
