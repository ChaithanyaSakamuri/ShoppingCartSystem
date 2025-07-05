package models;

import utils.FileHandler;

public class ShoppingCart {
    private CartItem head;
    private int itemCount;
    private Item[] availableItems; // Array of available products

    public ShoppingCart(Item[] availableItems) {
        this.head = null;
        this.itemCount = 0;
        this.availableItems = availableItems;
    }

    // Add item to cart
    public void addItem(String itemId, int quantity) {
        Item item = findItemById(itemId);
        if (item == null) {
            System.out.println("Item not found!");
            return;
        }

        CartItem current = head;
        while (current != null) {
            if (current.getItem().getId().equals(itemId)) {
                current.setQuantity(current.getQuantity() + quantity);
                System.out.println("Quantity updated for " + item.getName());
                return;
            }
            current = current.getNext();
        }

        CartItem newItem = new CartItem(item, quantity);
        newItem.setNext(head);
        head = newItem;
        itemCount++;
        System.out.println(item.getName() + " added to cart.");
    }

    // Remove item from cart
    public void removeItem(String itemId) {
        if (head == null) {
            System.out.println("Cart is empty!");
            return;
        }

        if (head.getItem().getId().equals(itemId)) {
            System.out.println(head.getItem().getName() + " removed from cart.");
            head = head.getNext();
            itemCount--;
            return;
        }

        CartItem current = head;
        while (current.getNext() != null) {
            if (current.getNext().getItem().getId().equals(itemId)) {
                System.out.println(current.getNext().getItem().getName() + " removed from cart.");
                current.setNext(current.getNext().getNext());
                itemCount--;
                return;
            }
            current = current.getNext();
        }

        System.out.println("Item not found in cart!");
    }

    // Update item quantity
    public void updateQuantity(String itemId, int newQuantity) {
        CartItem item = findCartItemById(itemId);
        if (item != null) {
            item.setQuantity(newQuantity);
            System.out.println("Quantity updated for " + item.getItem().getName());
        } else {
            System.out.println("Item not found in cart!");
        }
    }

    // Calculate total price
    public double calculateTotalPrice() {
        double total = 0;
        CartItem current = head;
        while (current != null) {
            total += current.getTotalPrice();
            current = current.getNext();
        }
        return total;
    }

    // Display cart contents
    public void displayCart() {
        if (head == null) {
            System.out.println("Your cart is empty!");
            return;
        }

        System.out.println("\n===== Your Shopping Cart =====");
        CartItem current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
        System.out.println("Total: $" + calculateTotalPrice());
        System.out.println("=============================");
    }

    // Save cart to file
    public void saveCartToFile(String filename) {
        FileHandler.saveCartToFile(this, filename);
    }

    // Helper methods
    private Item findItemById(String itemId) {
        for (Item item : availableItems) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    private CartItem findCartItemById(String itemId) {
        CartItem current = head;
        while (current != null) {
            if (current.getItem().getId().equals(itemId)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // Getters
    public CartItem getHead() {
        return head;
    }

    public int getItemCount() {
        return itemCount;
    }

    public Item[] getAvailableItems() {
        return availableItems;
    }
}   
