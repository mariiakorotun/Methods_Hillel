package program;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nWelcome to the \"Shop\" shop!\nEnter your price to determine the discount: ");

        double price = negativePrice(scanner);
        double discount = discountСalculation(price);
        double amount = amountDue(price, discount);
        clientInformation(price,discount,amount);

        scanner.close();
    }
    private static double negativePrice(Scanner scanner){
        double newPrice;

        do {
            System.out.print("Enter a price: ");
            String input = scanner.next();
            newPrice = Double.parseDouble(input);
            if (newPrice < 0) {
                System.out.println("Error: Negative price entered. Please try again.");
            }
        } while (newPrice < 0);

        return newPrice;
    }
    private static double discountСalculation(double price){
       double discount;
        if(price <= 5_000) discount = price * 0.05;
        else if (price > 5_000 && price <= 10_000) discount = price * 0.1;
        else discount = price * 0.15;
        return discount;
    }
    private static double amountDue(double price, double discount){
        return price + discount;
    }
    private static void clientInformation(double price, double discount, double amount){
        System.out.printf("""
                
                Price: %.2f
                Discount: %.2f
                ---------------------------------------
                TOTAL PRICE: %.2f
                """, price, discount,amount);
    }
}
