package SimpleBankingApplication;

import java.io.IOException;

import java.util.Scanner;

public class BankMenuDrivenProgram {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		AccountDetails accountDetails =  new AccountDetails();
		char ch;
		
		System.out.println("\t ----------------------------------------");
		System.out.println("\t  Welcome To Simple Banking Application ");
		System.out.println("\t ----------------------------------------");
		System.out.println();
		
		do {
			
			System.out.println("1 - Open New Account ");
			System.out.println("2 - Show all Account");
			System.out.println("3 - Search Account");
			System.out.println("4 - Registration");
			System.out.println("5 - Login");
			System.out.println("0 - Exit");
			
			System.out.print("Enter your Choice: ");
			int option = scan.nextInt();
			
			switch (option) {
			case 1:
				System.out.println();
				System.out.println("# Open new Account #");
				accountDetails.addNewAccount();
				break;
				
			case 2:
				System.out.println();
				System.out.println("# Show all Account Details #");
				accountDetails.showAccountDetails();
				break;
				
			case 3:
				System.out.println();
				System.out.println("# Search Account #");
				accountDetails.searchAccount();
				break;
				
			case 4:
				System.out.println();
				System.out.println("# Register #");
				try {
					accountDetails.registration();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
				
			case 5:
				System.out.println();
				System.out.println("# Login #");
				accountDetails.login();
				break;
				
			case 0:
				break;
				
			default:
				System.out.println("Enter valid option");
				break;
			}
			System.out.println();
			System.out.print("Want to perform more operations On Account(Y/N): ");
			
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
		
	}

}