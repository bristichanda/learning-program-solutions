import java.util.Scanner;

public class Main {

    // Recursive function to calculate future value
    public static double calculateFutureValue(double amount, double rate, int years) {
        if (years == 0)
            return amount;
        return (1 + rate) * calculateFutureValue(amount, rate, years - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter annual growth rate (as decimal, e.g., 0.08 for 8%): ");
        double rate = sc.nextDouble();

        System.out.print("Enter number of years to forecast: ");
        int years = sc.nextInt();

        double futureValue = calculateFutureValue(amount, rate, years);
        System.out.printf("Future value after %d years: ₹%.2f\n", years, futureValue);

        sc.close();
    }
}
