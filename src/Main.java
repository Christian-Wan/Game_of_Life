import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Savings life;
        String choice = "";
        System.out.print("Would you like to use a preset life (y/n): ");
        choice = s.nextLine();
        if (choice.equals("y")) {
            life = new Savings();
        }
        else {
            double job, studentLoan, rent, rentalInsurance, streamingServices, internet, groceries, dataPlan, commutingCost, extra;
            int years;
            System.out.print("How much do you make per year: ");
            job = Double.parseDouble(s.nextLine());
            System.out.print("How much student loan debt do you pay per month: ");
            studentLoan = Double.parseDouble(s.nextLine());
            if (studentLoan != 0) {
                System.out.print("How long is your loan term in years: ");
                years = Integer.parseInt(s.nextLine());
            }
            else {
                years = 0;
            }
            System.out.print("How much rent do you pay per month: ");
            rent = Double.parseDouble(s.nextLine());
            System.out.print("How much is you rental insurance: ");
            rentalInsurance = Double.parseDouble(s.nextLine());
            System.out.print("How much are your streaming services per month: ");
            streamingServices = Double.parseDouble(s.nextLine());
            System.out.print("How much is your internet per month: ");
            internet = Double.parseDouble(s.nextLine());
            System.out.print("How much do you pay for groceries per month: ");
            groceries = Double.parseDouble(s.nextLine());
            System.out.print("How much is your data plan per month: ");
            dataPlan = Double.parseDouble(s.nextLine());
            System.out.print("How much is your commuting cost per month: ");
            commutingCost = Double.parseDouble(s.nextLine());
            System.out.print("How much are you spending on yourself per month: ");
            extra = Double.parseDouble(s.nextLine());
            life = new Savings(job, studentLoan, rent, rentalInsurance, streamingServices, internet, groceries, dataPlan, commutingCost, extra, years);
        }
        while (life.getSaved() < 150000) {
            life.updateSavings();
            life.unfortunate();
            System.out.println(life);
            if (life.getMonth() % 12 == 0) {
                life.updateCosts();
            }
            if (!choice.equals("esc")) {
                System.out.println("Press enter to continue or type esc to skip");
                choice = s.nextLine();
            }
        }
        System.out.println();
        System.out.println("It took " + (life.getMonth() / 12) + " years and " + (life.getMonth() % 12) + " months to save $150,000");
    }
}