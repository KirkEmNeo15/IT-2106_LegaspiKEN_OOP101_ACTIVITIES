import java.util.Scanner;

public class CanteenOrderingSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Menu
        String[] items = {
            "Chicken Rice",
            "Cheeseburger",
            "French Fries",
            "Spaghetti",
            "Iced Coffee"
        };

        double[] prices = {
            85.00,
            110.00,
            60.00,
            95.00,
            75.00
        };

        int totalItems = 0;
        double totalBeforeDiscount = 0.00;
        double totalDiscount = 0.00;

        char again = 'Y';

        while (again == 'Y' || again == 'y') {

            // Display menu
            System.out.println();
            System.out.println("=====     M E N U     =====");

            for (int i = 0; i < items.length; i++) {
                System.out.printf("%d. %-15s - $%.2f%n",
                        i + 1, items[i], prices[i]);
            }

            System.out.println();

            // Input item number
            System.out.print("Enter item number: ");
            int itemNumber = input.nextInt();

            // Input quantity
            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            // Validate order
            if (itemNumber < 1 || itemNumber > 5 ||
                    quantity < 1 || quantity > 10) {

                System.out.println();
                System.out.println(
                    "Invalid order! Please enter a valid item and quantity."
                );

                continue;
            }

            // Student status
            System.out.print("Are you a student? (Y/N): ");
            char student = input.next().charAt(0);

            // Calculate subtotal
            double subtotal = prices[itemNumber - 1] * quantity;

            // Calculate discount
            double discountRate;

            if (student == 'Y' || student == 'y') {

                if (subtotal >= 500) {
                    // Student + $500 or more = 15%
                    discountRate = 0.15;
                } else {
                    // Student = 10%
                    discountRate = 0.10;
                }

            } else {

                if (subtotal >= 500) {
                    // Non-student + $500 or more = 5%
                    discountRate = 0.05;
                } else {
                    // No discount
                    discountRate = 0.00;
                }
            }

            double discount = subtotal * discountRate;
            double orderTotal = subtotal - discount;

            // Display order information
            System.out.println();
            System.out.printf("Subtotal: $%.2f%n", subtotal);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Order total: $%.2f%n", orderTotal);

            // Add to overall totals
            totalItems += quantity;
            totalBeforeDiscount += subtotal;
            totalDiscount += discount;

            // Ask for another order
            System.out.println();
            System.out.print("Do you want to order again? (Y/N): ");
            again = input.next().charAt(0);
        }

        // Final summary
        double finalAmount = totalBeforeDiscount - totalDiscount;

        System.out.println();
        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: $%.2f%n",
                totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n",
                totalDiscount);
        System.out.printf("Final amount to pay: $%.2f%n",
                finalAmount);
        System.out.println("Thank you for ordering!");

        input.close();
    }
}
