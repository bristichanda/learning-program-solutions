package org.example;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<>();
    private String stockSymbol;
    private double stockPrice;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockSymbol, stockPrice);
        }
    }

    public void setStockPrice(String symbol, double price) {
        this.stockSymbol = symbol;
        this.stockPrice = price;
        System.out.println("\nStock Price Updated: " + stockSymbol + " = $" + stockPrice);
        notifyObservers();
    }
}
