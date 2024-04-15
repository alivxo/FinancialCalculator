package com.pluralsight;

import java.text.NumberFormat;
import java.util.Scanner;

public class financialcalculator {
    public static final int monthsInYears = 12;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Which calculator do you want to use? (Choose 1(Mortgage Calculator), 2(Future Calculator), 3(Present Value): ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print(MortgageCalculator());
        } else if (choice == 2) {
            System.out.print(FutureCalculator());
        } else if (choice == 3) {
            System.out.print(PresentValue());
        }

    }

        public static double MortgageCalculator() {
            // Calculator 1 -- Mortgage Calculator
            Scanner sc1 = new Scanner(System.in);

            System.out.print("Enter the loan amount: ");
            double loanAmount = sc1.nextDouble();

            System.out.print("Enter the interest rate: ");
            double interestRate = sc1.nextDouble();

            System.out.print("Enter the number of years: ");
            int years = sc1.nextInt();

            double convertInterestRate = interestRate / 100;
            double monthlyInterestRate = convertInterestRate / monthsInYears;
            int totalMonths = years * monthsInYears;

            double monthlyPayments = loanAmount * (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, totalMonths))) / ((Math.pow(1 + monthlyInterestRate, totalMonths)) - 1);

            System.out.println("Monthly payments: " + NumberFormat.getCurrencyInstance().format(monthlyPayments));

            return monthlyPayments;

    }
        // Calculator 2 -- Future Calulator
        public static double FutureCalculator() {

        Scanner sc2 = new Scanner(System.in);

        System.out.print("Enter Present Value: ");
        double presentValue = sc2.nextDouble();

        System.out.print("Enter the rate amount: ");
        double rateAmount = sc2.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = sc2.nextInt();

        double convertInterestRate = rateAmount / 100;

        double futureValue = presentValue * ((Math.pow( 1 + convertInterestRate,years)));

        System.out.println("Future Value: " + NumberFormat.getCurrencyInstance().format(futureValue));

        return futureValue;


        }
         // Calculator 3 - Present Value

        public static double PresentValue () {

        Scanner sc3 = new Scanner(System.in);

        System.out.print("Enter Payment Each Month : ");
        double futureValue = sc3.nextDouble();

        System.out.print("Enter the interest rate: ");
        double interestRate = sc3.nextDouble();

        System.out.print("Enter the number of periods: ");
        int periods = sc3.nextInt();

        double convertInterestRate = interestRate / 100;
        int periodYears = periods * monthsInYears;
        double presentValue = futureValue * (( 1- (Math.pow(1 + convertInterestRate, -periodYears)))/ convertInterestRate);

        System.out.println("PresentValue: " + NumberFormat.getCurrencyInstance().format(presentValue));

        return presentValue;


        }
}

