import Config.RandomGenerator;
import Payment.AndroidPay;
import Payment.ApplePay;
import Payment.GooglePay;
import Payment.PayMethod;
import discount.DiscountDecorator;
import discount.NewYearDiscount;
import discount.NoDiscount;
import discount.RegularCustumerDiscount;
import flowers.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! This is a flower shop!");
        System.out.println("We have an already formed bouquet or you can form it by yourself.");
        System.out.println("What type do you prefer?Input 1 if formed bouquet or 2 otherwise.");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();
        FlowerBouquet my_bouquet = new FlowerBouquet();
        if (Integer.valueOf(answer) == 1) {
            ArrayList<ArrayList> bouquets = new ArrayList<ArrayList>();
            RandomGenerator randomGenerator = new RandomGenerator();
            ArrayList new_bouquet;
            for (int i = 1; i <= randomGenerator.getRandomInt(1, 10); i++) {
                FlowerBouquet flowerBouquet = new FlowerBouquet();
                flowerBouquet.getRandomFlowerBouquet();
                new_bouquet = new ArrayList();
                new_bouquet.add(i);
                new_bouquet.add(flowerBouquet);
                bouquets.add(new_bouquet);
            }
            System.out.println("Currently available bouquets");
            for (ArrayList flowerBouquet : bouquets) {
                System.out.println("Bucket number " + flowerBouquet.get(0) + " is\n" + flowerBouquet.get(1));
            }
            System.out.println("Which bouquet do you want?");
            answer = scan.nextLine();
            for (ArrayList bouquet : bouquets) {
                if (bouquet.get(0) == Integer.valueOf(answer)) {
                    my_bouquet = (FlowerBouquet) bouquet.get(1);
                }
            }
        }
        System.out.println("Do you want to add some flower to you bouquet?If yes input yes, if no input no.");
        answer = scan.nextLine();
        Flower flower;
        while (answer.equals("yes")) {
            System.out.println("Which type of flowers do you want add?");
            answer = scan.nextLine();
            switch ((char) (answer.charAt(0))) {
                case 'C':
                    flower = new Chamomile();
                    break;
                case 'R':
                    flower = new Rosie();
                    break;
                case 'T':
                    flower = new Tulip();
                    break;
                default:
                    flower = new Flower();
                    System.out.println("There no flower with this type!");
            }
            if (!flower.getClass().getSimpleName().equals("Flower")) {
                flower.getRandomConfig();
                my_bouquet.addFlower(flower);
            }
            System.out.println("Do you want to add some flower to you bouquet?If yes input yes, if no input no.");
            answer = scan.nextLine();
        }
        System.out.println("Do you have an allergic reaction to any kind of flowers?");
        answer = scan.nextLine();
        while (answer.equals("yes")) {
            System.out.println("Which type of flowers do you want remove from bouquet?");
            answer = scan.nextLine();
            my_bouquet.removeAllFlowersThisType(answer);
            System.out.println("Do you have an allergic reaction to any kind of flowers?");
            answer = scan.nextLine();
        }
        if (my_bouquet.getBucket().size() == 0) {
            System.out.println("You haven`t selected any bouquet");
        } else {
            System.out.println("If you have any type of discount please input it type.\n");
            System.out.println("Input 1 if you have New Year discount, 2 if regular custumer and 3 if no one.\n");
            int method = Integer.valueOf(scan.nextLine());
            DiscountDecorator discount;
            switch (method) {
                case 1:
                    discount = new DiscountDecorator(new NewYearDiscount());
                    my_bouquet.setPrice(discount.new_price(my_bouquet.getPrice()));
                    break;
                case 2:
                    discount = new DiscountDecorator(new RegularCustumerDiscount());
                    my_bouquet.setPrice(discount.new_price(my_bouquet.getPrice()));
                    break;
                case 3:
                    discount = new DiscountDecorator(new NoDiscount());
                    my_bouquet.setPrice(discount.new_price(my_bouquet.getPrice()));
                    break;
                default:
                    discount = new DiscountDecorator(new NoDiscount());
                    my_bouquet.setPrice(discount.new_price(my_bouquet.getPrice()));
                    System.out.println("Wrong data! You discount is 0!");
                    break;
            }
            System.out.println("if you want pay by GooglePay input 1, if AndroidPay 2 and if ApplePay 3");
            method = Integer.valueOf(scan.nextLine());
            PayMethod payMethod;
            switch (method) {
                case 1:
                    payMethod = new PayMethod(new GooglePay());
                    payMethod.pay(my_bouquet);
                    break;
                case 2:
                    payMethod = new PayMethod(new AndroidPay());
                    payMethod.pay(my_bouquet);
                    break;
                case 3:
                    payMethod = new PayMethod(new ApplePay());
                    payMethod.pay(my_bouquet);
                    break;
                default:
                    System.out.println("Wrong data! Remake all!");
                    break;
            }
        }
    }
}
