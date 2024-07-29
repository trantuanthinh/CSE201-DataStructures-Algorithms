import java.util.Scanner;

public class Scratch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        double interestRate = ((double) x * m / n) * (Math.pow(1 + (double) x * m / n, k) - 1);
        int remainingCost = n;
        for (int i = 1; i < k; i++) {
            remainingCost -= x;
            remainingCost += remainingCost * interestRate;
        }
        int payment = remainingCost;
        if ((double) (remainingCost - payment) / payment > 0.5) {
            payment += 1;
        }
        System.out.println(payment);
    }
}