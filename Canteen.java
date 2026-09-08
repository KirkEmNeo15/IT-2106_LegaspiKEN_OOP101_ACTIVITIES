import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] items = {"Burger", "Pizza", "Pasta", "Sandwich", "Milk Tea"};
        double[] prices = {80.00, 120.00, 100.00, 70.00, 90.00};

        char again = 'Y';

        while (again == 'Y' || again == 'y') {

            // Display menu
            System.out.println("===== M E N U =====");
            for (int i = 0; i < items.length; i++) {
                System.out.printf("%d. %-10s - $%.2f%n",
                        i + 1, items[i], prices[i]);
            }

            System.out.print("\nEnter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            // Validate item number and quantity
            if (itemNumber < 1 || itemNumber > items.length || quantity <= 0) {
                System.out.println("\nInvalid order! Please enter a valid item and quantity.");
                continue;
            }

            System.out.print("Are you a student? (Y/N): ");
            char student = input.next().charAt(0);

            // Calculate subtotal
            double subtotal = prices[itemNumber - 1] * quantity;
            double discount = 0;

            // Apply 10% student discount
            if (student == 'Y' || student == 'y') {
                discount = subtotal * 0.10;
            }

            double total = subtotal - discount;

            System.out.printf("%nSubtotal: $%.2f%n", subtotal);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Order total: $%.2f%n", total);

            System.out.print("\nDo you want to order again? (Y/N): ");
            again = input.next().charAt(0);

            System.out.println();
        }

        System.out.println("Thank you for your order!");
        input.close();
    }
}
