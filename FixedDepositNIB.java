import java.util.Scanner;

/**
 * Write a description of class g here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class FixedDepositNIB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int again = 1;

        while (again == 1) {

            System.out.println("\n======================================");
            System.out.println("     NIB FIXED DEPOSIT CALCULATOR");
            System.out.println("======================================");

            System.out.print("Enter Principal Amount (Min 1000): Rs. ");
            double P = sc.nextDouble();

            if (P < 1000) {
                System.out.println("x Minimum deposit amount is Rs. 1000");
                continue;
            }

            System.out.print("Enter Annual Interest Rate (8% - 12%): ");
            double annualRate = sc.nextDouble();

            System.out.print("Enter Investment Duration (Max 5 Years): ");
            int years = sc.nextInt();

            if (years > 5) {
                System.out.println("! Maximum allowed duration is 5 years.");
                years = 5;
            }

            double monthlyRate = annualRate / 12 / 100;
            int months = years * 12;

            double maturityAmount = P * Math.pow(1 + monthlyRate, months);

            double feeRate = 0.005;
            double processingFee = maturityAmount * feeRate;
            double finalAmount = maturityAmount - processingFee;

            System.out.println("\n----------- DEPOSIT SUMMARY -----------");
            System.out.printf("Principal Amount      : Rs. %.2f%n", P);
            System.out.printf("Interest Rate         : %.2f %% %n", annualRate);
            System.out.println("Investment Period     : " + years + " Years");
            System.out.println("---------------------------------------");
            System.out.printf("Maturity Amount       : Rs. %.2f%n", maturityAmount);
            System.out.printf("Processing Fee (0.5%%) : Rs. %.2f%n", processingFee);
            System.out.println("---------------------------------------");
            System.out.printf("Final Amount Received : Rs. %.2f%n", finalAmount);
            System.out.println("---------------------------------------");

            System.out.print("\nDo you want to calculate again? (1 = Yes / 0 = No): ");
            again = sc.nextInt();
        }

        System.out.println("\n Thank You for Using NIB FD Calculator!");
        sc.close();
    }
}
