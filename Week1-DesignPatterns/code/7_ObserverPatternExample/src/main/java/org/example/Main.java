package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileUser = new MobileApp("Alice");
        Observer webUser = new WebApp("Bob");

        stockMarket.registerObserver(mobileUser);
        stockMarket.registerObserver(webUser);

        stockMarket.setStockPrice("AAPL", 189.25);
        stockMarket.setStockPrice("GOOGL", 2780.50);

        // Deregister one observer
        stockMarket.removeObserver(webUser);

        stockMarket.setStockPrice("MSFT", 342.10);
    }
}