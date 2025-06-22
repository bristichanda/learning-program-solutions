package org.example;

public class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway gateway) {
        this.payPalGateway = gateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.sendPayment(amount);
    }
}
