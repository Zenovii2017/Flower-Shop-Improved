package discount;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DiscountDecorator implements Discount {
    protected Discount discount;

    public int new_price(int price){
        return this.discount.new_price(price);
    }
}
