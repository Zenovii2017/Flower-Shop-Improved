package Payment;

import flowers.FlowerBouquet;

import java.util.Scanner;

public class GooglePay implements Payment {
    @Override
    public void pay(FlowerBouquet bouquet) {
        Scanner scan = new Scanner(System.in);
        System.out.println("You want buy this bouquet:\n" + bouquet);
        System.out.println("Price of it is " + bouquet.getPrice() + "UAH\n");
        System.out.println("Input number of your card:\n");
        String login = scan.nextLine();
        System.out.println("Input key of your card:\n");
        String key = scan.nextLine();
        System.out.println("Your order is processing!");
    }
}
