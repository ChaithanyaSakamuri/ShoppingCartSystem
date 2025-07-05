import models.Item;
import models.ShoppingCart;
import utils.FileHandler;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Sample available items
        Item[] availableItems = {
            new Item("1", "Laptop", 999.99),
            new Item("2", "Smartphone", 699.99),
            new Item("3", "Headphones", 149.99),
            new Item("4", "Mouse", 24.99),
            new Item("5", "Keyboard", 49.99)
        };

        ShoppingCart cart = new ShoppingCart(availableItems);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Shopping Cart System ===");

        while (running) {
            System.out.println("\nOptions:");
            System.out.println("1. Display available items");
            System.out.println("2. Display cart");
            System.out.println("3. Add item to cart");
            System.out.println("4. Remove item from cart");
            System.out.println("5. Update item quantity");
            System.out.println("6. Save cart to file");
            System.out.println("7. Load cart from file");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayAvailableItems(availableItems);
                    break;
                case 2:
                    cart.displayCart();
                    break;
                case 3:
                    addItemToCart(cart, scanner);
                    break;
                case 4:
                    removeItemFromCart(cart, scanner);
                    break;
                case 5:
                    updateItemQuantity(cart, scanner);
                    break;
                case 6:
                    System.out.print("Enter filename to save: ");
                    String saveFilename = scanner.nextLine();
                    cart.saveCartToFile(saveFilename);
                    break;
                case 7:
                    System.out.print("Enter filename to load: ");
                    String loadFilename = scanner.nextLine();
                    FileHandler.loadCartFromFile(cart, loadFilename);
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Shopping Cart System!");
    }

    private static void displayAvailableItems(Item[] items) {
        System.out.println("\n===== Available Items =====");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("==========================");
    }

    private static void addItemToCart(ShoppingCart cart, Scanner scanner) {
        System.out.print("Enter item ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        cart.addItem(id, quantity);
    }

    private static void removeItemFromCart(ShoppingCart cart, Scanner scanner) {
        System.out.print("Enter item ID to remove: ");
        String id = scanner.nextLine();
        cart.removeItem(id);
    }

    private static void updateItemQuantity(ShoppingCart cart, Scanner scanner) {
        System.out.print("Enter item ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter new quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        cart.updateQuantity(id, quantity);
    }
}