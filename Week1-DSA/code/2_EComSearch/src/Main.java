import java.util.*;

public class Main {

    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int id, String name, String category) {
            this.productId = id;
            this.productName = name;
            this.category = category;
        }

        @Override
        public String toString() {
            return productId + " - " + productName + " [" + category + "]";
        }
    }

    // Linear Search
    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;
        name = name.toLowerCase();

        while (left <= right) {
            int mid = (left + right) / 2;
            String midName = products[mid].productName.toLowerCase();

            if (midName.equals(name)) {
                return products[mid];
            } else if (midName.compareTo(name) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for product " + (i + 1));
            System.out.print("Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();  // consume newline

            System.out.print("Product Name: ");
            String name = sc.nextLine();

            System.out.print("Category: ");
            String category = sc.nextLine();

            products[i] = new Product(id, name, category);
        }

        System.out.print("\nEnter product name to search: ");
        String searchName = sc.nextLine();

        // Perform Linear Search
        System.out.println("\nLinear Search Result:");
        Product resultLinear = linearSearch(products, searchName);
        System.out.println(resultLinear != null ? resultLinear : "Product not found");

        // perform Binary Search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
        System.out.println("\nBinary Search Result:");
        Product resultBinary = binarySearch(products, searchName);
        System.out.println(resultBinary != null ? resultBinary : "Product not found");

        sc.close();
    }
}
