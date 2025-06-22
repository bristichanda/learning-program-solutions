package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Base notifier
        Notifier notifier = new EmailNotifier();

        // Add SMS notification
        notifier = new SMSNotifierDecorator(notifier);

        // Add Slack notification
        notifier = new SlackNotifierDecorator(notifier);

        // Send one message via multiple channels
        notifier.send("System Alert: High CPU usage detected!");
    }
}