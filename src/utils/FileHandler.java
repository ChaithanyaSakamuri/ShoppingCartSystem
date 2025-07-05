package utils;

import models.ShoppingCart;
import models.CartItem;
import java.io.*;

public class FileHandler {
    public static void saveCartToFile(ShoppingCart cart, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            CartItem current = cart.getHead();
            while (current != null) {
                writer.println(current.getItem().getId() + "," + current.getQuantity());
                current = current.getNext();
            }
            System.out.println("Cart saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving cart to file: " + e.getMessage());
        }
    }

    public static void loadCartFromFile(ShoppingCart cart, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    cart.addItem(parts[0], Integer.parseInt(parts[1]));
                }
            }
            System.out.println("Cart loaded from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading cart from file: " + e.getMessage());
        }
    }
}