package models;

public class CartItem {
    private Item item;
    private int quantity;
    private CartItem next;

    public CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.next = null;
    }

    // Getters and setters
    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartItem getNext() {
        return next;
    }

    public void setNext(CartItem next) {
        this.next = next;
    }

    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return item.toString() + " x " + quantity + " = $" + getTotalPrice();
    }
}