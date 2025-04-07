package model.entities;

import model.entities.exceptions.DomainException;

/**
 * Represents a simple bank account with basic deposit and withdrawal functionality.
 */
public class BankAccount {

	// The name of the account holder
	private String holder;
	
	// The current balance of the account
	private Double balance;
	
	public BankAccount(String holder, Double balance) {
		super();
		this.holder = holder;
		this.balance = balance;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	// Deposits a given amount into the account.
	public void deposit(double amount) {
		balance += amount;
	}
	
	
	// Withdraws a given amount from the account, if sufficient balance exists.
	public void withdraw(double amount) {
		if(amount > balance) {
			throw new DomainException("Not enought balance!");
		}
		else {
			balance -= amount;
		}
	}

	
	// Returns a string representation of the account's balance.
	@Override
	public String toString() {
		return "Balance: $" + String.format("%.2f", balance);
	}	
}
