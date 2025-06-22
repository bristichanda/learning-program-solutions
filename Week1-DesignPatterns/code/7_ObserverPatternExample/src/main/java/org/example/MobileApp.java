package org.example;

public class MobileApp implements Observer {
    private final String user;

    public MobileApp(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Mobile App [" + user + "]: " + stockSymbol + " is now $" + price);
    }
}
