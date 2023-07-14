import java.util.Scanner;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EcommercePlatform ecommercePlatform = new EcommercePlatform();
        ecommercePlatform.registerUser("john123", "password");
        ecommercePlatform.registerUser("jane456", "pass123");
        ecommercePlatform.registerUser("Brandon", "2004");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        User authenticatedUser = ecommercePlatform.authenticateUser(username, password);
        if (authenticatedUser != null) {
            System.out.println("Authentication successful!");

            System.out.println("Available products:");
            List<Product> products = ecommercePlatform.getProducts();
            for (Product product : products) {
                System.out.println(product.getName() + " - " + product.getDescription());
                System.out.println("Price: $" + product.getPrice());
                System.out.println("Stock: " + product.getStock());
                System.out.println("---------------------------");
            }

            System.out.print("Enter the name of the product you want to purchase: ");
            String productName = scanner.nextLine();

            Product selectedProduct = null;
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(productName)) {
                    selectedProduct = product;
                    break;
                }
            }

            if (selectedProduct != null) {
                System.out.print("Enter the quantity you want to purchase: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Consume the remaining newline character

                if (selectedProduct.getStock() >= quantity) {
                    double totalPrice = selectedProduct.getPrice() * quantity;
                    System.out.println("Total Price: $" + totalPrice);

                    System.out.print("Select payment method (cash or card): ");
                    String paymentMethod = scanner.nextLine();

                    if (paymentMethod.equalsIgnoreCase("cash")) {
                        System.out.println("Payment successful!");
                        // Update stock quantity
                        selectedProduct.setStock(selectedProduct.getStock() - quantity);
                    } else if (paymentMethod.equalsIgnoreCase("card")) {
                        System.out.print("Enter 16-digit card number: ");
                        String cardNumber = scanner.nextLine();

                        System.out.print("Enter your PIN: ");
                        String pin = scanner.nextLine();


                        System.out.println("Payment successful!");
                        // Update stock quantity
                        selectedProduct.setStock(selectedProduct.getStock() - quantity);
                    } else {
                        System.out.println("Invalid payment method. Payment failed.");
                    }
                } else {
                    System.out.println("Insufficient stock for the selected product.");
                }
            } else {
                System.out.println("Product not found.");
            }
        } else {
            System.out.println("Authentication failed.");
        }

        scanner.close();
        System.out.println("Have a nice day!");
    }
}
