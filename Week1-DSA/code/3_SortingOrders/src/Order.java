class Order {
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
        return orderId + " - " + customerName + " - ₹" + totalPrice;
    }
}
