package Payment;

import flowers.FlowerBouquet;

import java.util.Scanner;

public class AndroidPay implements Payment {
    @Override
    public void pay(FlowerBouquet bouquet) {
        Scanner scan = new Scanner(System.in);
        System.out.println("You want buy this bouquet:\n" + bouquet);
        System.out.println("Price of it is " + bouquet.getPrice() + "UAH\n");
        System.out.println("Take your phone to the cash register:\n");
        System.out.println("Your order is processing!");
    }
}
