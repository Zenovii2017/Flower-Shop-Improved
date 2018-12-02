package Payment;

import flowers.FlowerBouquet;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PayMethod {
    private Payment payment;

    public void pay(FlowerBouquet bouquet){
        payment.pay(bouquet);
    }
}
