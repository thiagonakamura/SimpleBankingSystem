package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.BankAccount;
import model.entities.exceptions.DomainException;


/**
 * Entry point of the application for testing bank account operations.
 * 
 * This console program allows the user to create a bank account and perform
 * either a deposit or a withdrawal operation. It demonstrates exception handling 
 * using a custom DomainException to validate business rules (e.g., insufficient balance).
 */
public class Program {

	public static void main(String[] args) {
		
        // Set locale to US to ensure consistent number formatting
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		
		
		try {
			// Get account holder information and initial balance from user input
			System.out.print("Holder´s name: ");
			String name = sc.nextLine();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();
			
	        // Create a new bank account instance
			BankAccount ba = new BankAccount(name, balance);
			
			System.out.print("Deposit or withdraw (d/w)? ");
			char action = sc.next().toUpperCase().charAt(0);
			
			if(action == 'D') {
				System.out.print("Enter the amount to deposit: ");
				double deposit = sc.nextDouble();
				ba.deposit(deposit);
			}
			else {
                // Perform withdrawal operation with validation and retry logic
				boolean success = false;
				
				do {
					try {
						System.out.print("Enter the amount to withdraw: ");
						double withdraw = sc.nextDouble();
						ba.withdraw(withdraw); // May throw DomainException
						success = true;
					}
					catch(DomainException e) {
						// Handle business rule violation (e.g., insufficient funds)
						System.out.println("\nWithdraw error: " + e.getMessage());
						System.out.println(ba);
					}			
				} while(!success); // Keep retrying until a valid withdrawal is made
				
			}
			
			// Print final account balance
			System.out.println(ba);
		}
		catch(RuntimeException e2) {
			// Catch any unexpected runtime exceptions (e.g., input mismatch)
			System.out.println("Unexpected error!");
		}
		
		sc.close();
	}

}
