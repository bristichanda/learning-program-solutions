import java.util.*;

public class Main {

    static class Order {
        int orderId;
        String customerName;
        double totalPrice;

        public Order(int id, String name, double price) {
            this.orderId = id;
            this.customerName = name;
            this.totalPrice = price;
        }

        @Override
        public String toString() {
            return orderId + " - " + customerName + " - Rs." + totalPrice;
        }
    }

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();
        sc.nextLine();

        Order[] orders = new Order[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Order " + (i + 1));
            System.out.print("Order ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Total Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            orders[i] = new Order(id, name, price);
        }

        // Bubble Sort
        Order[] bubbleSorted = Arrays.copyOf(orders, n);
        bubbleSort(bubbleSorted);
        System.out.println("\nOrders Sorted by Bubble Sort:");
        printOrders(bubbleSorted);

        // Quick Sort
        Order[] quickSorted = Arrays.copyOf(orders, n);
        quickSort(quickSorted, 0, n - 1);
        System.out.println("\nOrders Sorted by Quick Sort:");
        printOrders(quickSorted);

        sc.close();
    }
}
