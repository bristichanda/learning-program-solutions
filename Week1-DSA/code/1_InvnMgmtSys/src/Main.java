import java.util.*;

public class Main {
    static Map<Integer, Product> inventory = new HashMap<>();

    public static void addProduct(Product p) {
        inventory.put(p.productId, p);
        System.out.println("Product added: " + p);
    }

    public static void updateProduct(int id, String newName, int newQty, double newPrice) {
        Product p = inventory.get(id);
        if (p != null) {
            p.productName = newName;
            p.quantity = newQty;
            p.price = newPrice;
            System.out.println("Product updated: " + p);
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void deleteProduct(int id) {
        Product removed = inventory.remove(id);
        if (removed != null) {
            System.out.println("Product deleted: " + removed);
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void displayAll() {
        System.out.println("Inventory:");
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        addProduct(new Product(101, "Keyboard", 50, 1000));
        addProduct(new Product(102, "Mouse", 70, 500));
        updateProduct(101, "Mechanical Keyboard", 45, 1500);
        deleteProduct(102);
        displayAll();
    }
}
