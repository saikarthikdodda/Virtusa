package com.java.main;

import com.java.service.AccountService;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountService service = new AccountService();

        while (true) {
            System.out.println("\n======== MAIN MENU ========");
            System.out.println("1. Create Account");
            System.out.println("2. Account Operations");
            System.out.println("3. Show All Accounts");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.println("Account Created Successfully!");
                        System.out.println("Account Number: " + service.createAccount(name).getAccountNumber());
                        break;

                    case 2:
                        System.out.print("Enter Account Number: ");
                        String accNo = sc.nextLine();
                        if(service.getAccount(accNo) == null){
                            System.out.println("Account Not Found!");
                        }
                        accountMenu(service, sc, accNo);
                        break;

                    case 3:
                        service.showAllAccounts();
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void accountMenu(AccountService service, Scanner sc, String accNo) {

        while (true) {
            try {
                System.out.println("\n------ ACCOUNT MENU ------");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Transfer");
                System.out.println("4. Show Balance");
                System.out.println("5. Back");
                System.out.print("Enter choice: ");

                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {

                    case 1:
                        System.out.print("Enter amount: ");
                        service.deposit(accNo, sc.nextDouble());
                        System.out.println("Deposit Successful");
                        break;

                    case 2:
                        System.out.print("Enter amount: ");
                        service.withdraw(accNo, sc.nextDouble());
                        System.out.println("Withdrawal Successful");
                        break;

                    case 3:
                        System.out.print("Enter destination account: ");
                        String dest = sc.nextLine();
                        System.out.print("Enter amount: ");
                        double amt = sc.nextDouble();
                        service.transfer(accNo, dest, amt);
                        System.out.println("Transfer Successful");
                        break;

                    case 4:
                        service.showBalance(accNo);
                        break;

                    case 5:
                        return;

                    default:
                        System.out.println("Invalid Option!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }



    }
}
