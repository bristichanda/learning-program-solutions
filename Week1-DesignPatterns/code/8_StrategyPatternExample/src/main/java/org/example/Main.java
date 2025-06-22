package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Use Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        context.executePayment(100.0);

        // Use PayPal
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.executePayment(200.0);
    }
}