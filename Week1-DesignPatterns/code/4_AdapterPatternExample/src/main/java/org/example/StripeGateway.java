package org.example;

public class StripeGateway {
    public void makePayment(double amountInUSD) {
        System.out.println("Paid Rs." + amountInUSD + " using Stripe.");
    }
}