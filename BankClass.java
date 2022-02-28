package SimpleBankingApplication;

import java.util.Scanner;

public class BankClass {
	/*
	 * 
	 * $$Simple Banking Application
	 * 
	 * Open New Account 
	 * Show All Account 
	 * Search Account 
	 * Registration 
	 * login 
	 * --Check balance 
	 * --Deposit 
	 * --Withdraw 
	 * Exit
	 * 
	 */
	long acc_No;
	String name;
	String acc_type;
	String address;
	double balance;

	public BankClass() {
		super();
	}

	public BankClass(long acc_No, String name, String acc_type, String address) {
		super();
		this.acc_No = acc_No;
		this.name = name;
		this.acc_type = acc_type;
		this.address = address;
	}

	public long getAcc_No() {
		return acc_No;
	}

	public void setAcc_No(long acc_No) {
		this.acc_No = acc_No;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public double getBalance() {
		return balance;
	}

	public BankClass setBalance(double balance) {
		this.balance = balance;
		return null;

	}

	Scanner scan = new Scanner(System.in);

	public BankClass newAccount() {
//		System.out.print("Enter Account No.: ");
		long acc_No = (long) (Math.random() * Math.pow(10, 11));
		System.out.print("Enter Account Holder Name: ");
		String name = scan.next();
		System.out.print("Enter Account Type: ");
		String acc_type = scan.next();
		System.out.print("Enter Address: ");
		String address = scan.next();
		return new BankClass(acc_No, name, acc_type, address);

	}

	@Override
	public String toString() {
		return " Account_No : " + acc_No + "\n Account Holder Name : " + name + "\n Account Type : " + acc_type
				+ "\n Address : " + address + "\n Balance : " + balance + "\n";
	}

}