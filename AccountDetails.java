package SimpleBankingApplication;

import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class AccountDetails extends BankClass {

	HashMap<Long, BankClass> map = new HashMap<Long, BankClass>();
	BankClass bankClass;

	public void addNewAccount() {
		bankClass = new BankClass().newAccount();

		int flag = 0;
		for (Entry<Long, BankClass> i : map.entrySet()) {
			if (i.getKey() == bankClass.getAcc_No()) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			map.put(bankClass.getAcc_No(), bankClass);
			System.out.println();
			System.out.println(map.get(bankClass.getAcc_No()));
			System.out.println();
			System.out.println("# Register #");
			try {
				registration();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Account Number is Already There");
		}
	}

	public void showAccountDetails() {
		for (Entry<Long, BankClass> i : map.entrySet()) {
			System.out.println(map.get(i.getKey()));
		}

//		for (Entry<Long, BankClass> i : map.entrySet()) {
//			System.out.println("Account No -  " + i.getKey());
//			System.out.println("Account Holder Name -  " + i.getValue().getName());
//			System.out.println("Account Type -  " + i.getValue().getAcc_type());
//			System.out.println("Account Balance: -  " + i.getValue().getBalance());
//			System.out.println();
//		}

	}

	public void searchAccount() {
		System.out.print("Enter account number to search: ");
		long acc_No = scan.nextLong();
		int flag = 0;
		for (Entry<Long, BankClass> i : map.entrySet()) {
			if (i.getKey() == acc_No) {
				flag = 1;
				System.out.println("Account No -  " + i.getKey());
				System.out.println("Account Holder Name -  " + i.getValue().getName());
				System.out.println("Account Type -  " + i.getValue().getAcc_type());
				System.out.println("Account Balance: -  " + i.getValue().getBalance());
				System.out.println();
				break;
			}
		}
		if (flag == 0) {
			System.out.println("Account Number not found");
		}

	}

	HashMap<Long, BankUserClass> map1 = new HashMap<Long, BankUserClass>();
	Scanner scan = new Scanner(System.in);

	

	public void registration() throws IOException {
		System.out.print("Enter Account Number: ");
		long acc_No = scan.nextLong();
		System.out.print("Enter User Id: ");
		String user_Id = scan.next();
//		System.out.print("Enter Password: ");
//		String password = scan.next();

		int dummy1 = 0;
		Console console = System.console();
		String password = "";
		if (console != null) {
			char [] ch = console.readPassword("Enter Password: ");
			password = String.valueOf(ch);
//			System.out.println("Password is: " + password);
			for (Entry<Long, BankClass> i : map.entrySet()) {
				for (Entry<Long, BankUserClass> j : map1.entrySet()) {
					if (i.getKey() == acc_No && j.getKey() == acc_No) {
						dummy1 = 1;
						break;
					} else if (i.getKey() == acc_No && j.getValue().getUser_Id().equals(user_Id)) {
						dummy1 = 2;
						break;
					}
				}
				if (i.getKey() == acc_No && dummy1 == 0) {
					dummy1 = 3;
					break;

				}
			}
			if (dummy1 == 0) {
				System.out.println("There is no such Account Number!!First Open a account");
			} else if (dummy1 == 1) {
				System.out.println("Account Number is alreday Registered");
			} else if (dummy1 == 2) {
				System.out.println("User_id is alreday Registered!!Try another User_id");
			} else {

				map1.put(acc_No, new BankUserClass(acc_No, user_Id, password));
				System.out.println("Registered Succesfully");
				System.out.println();
				System.out.println("# Login #");
				login();
			}
		}else {
			System.out.println("Console Not Found");
		} 
//		int dummy1 = 0;
//
//		for (Entry<Long, BankClass> i : map.entrySet()) {
//			for (Entry<Long, BankUserClass> j : map1.entrySet()) {
//				if (i.getKey() == acc_No && j.getKey() == acc_No) {
//					dummy1 = 1;
//					break;
//				} else if (i.getKey() == acc_No && j.getValue().getUser_Id().equals(user_Id)) {
//					dummy1 = 2;
//					break;
//				}
//			}
//			if (i.getKey() == acc_No && dummy1 == 0) {
//				dummy1 = 3;
//				break;
//
//			}
//		}
//		if (dummy1 == 0) {
//			System.out.println("There is no such Account Number!!First Open a account");
//		} else if (dummy1 == 1) {
//			System.out.println("Account Number is alreday Registered");
//		} else if (dummy1 == 2) {
//			System.out.println("User_id is alreday Registered!!Try another User_id");
//		} else {
//			
//			map1.put(acc_No, new BankUserClass(acc_No, user_Id, password));
//			System.out.println("Registered Succesfully");
//			System.out.println();
//			System.out.println("# Login #");
//			login();
//		}

	}

	public void login() {
		System.out.print("Enter User Id to Login: ");
		String userId = scan.next();
//		System.out.print("Enter Password: ");
//		String password = scan.next();
		Console console = System.console();
		String password = "";
		
		if (console != null) {
			char[] ch = console.readPassword("Enter Password: ");
			password = String.valueOf(ch);
//			System.out.println("Password is: " + password);
		} else {
			System.out.println("Console Not Found");
		}

		int dummy = 0;
		for (Entry<Long, BankUserClass> i : map1.entrySet()) {
			if (i.getValue().getUser_Id().equals(userId) && i.getValue().getPassword().equals(password)) {
				dummy = 1;
				break;
			}
		}
		if (dummy == 0) {
			System.out.println("Invalid UserId or Password...If not registered please choose Registration");

		} else {
			System.out.println();
			System.out.println("-----------------------");
			System.out.println("     Welcome " + userId);
			System.out.println("-----------------------");
			System.out.println();
			System.out.println("Which operation would you like to perform:");
			char choice;
			
			do {
				System.out.println("1: Check Balance");
				System.out.println("2: Deposite");
				System.out.println("3: Withraw");
//				System.out.println("4: Transfer");
				System.out.println("0: Exit");
				
				System.out.print("Enter your choice: ");
				int option1 = scan.nextInt();
				switch (option1) {
				case 1:
					viewBalance(userId);
					break;

				case 2:
					System.out.print("Enter amount to be deposited: ");
					double amount = scan.nextDouble();
					deposite(userId, amount);
					break;

				case 3:
					System.out.print("Enter amount to Withdraw: ");
					amount = scan.nextDouble();
					withdraw(userId, amount);
					break;

//				case 4:
//					transfer(userId);
//					break;

				case 0:
					break;

				default:
					System.out.println("Enter valid option");
					break;
				}
				System.out.println();
				System.out.print("Want more operations on login(Y/N): ");
				choice = scan.next().charAt(0);
			} while (choice == 'Y' || choice == 'y');
		}

	}

	public void deposite(String userId, double amount) {

		int flag = 0;

		for (Entry<Long, BankClass> i : map.entrySet()) {
			for (Entry<Long, BankUserClass> j : map1.entrySet()) {
				if (i.getValue().getAcc_No() == j.getValue().getAcc_No() && j.getValue().getUser_Id().equals(userId)) {
					flag = 1;
					balance = i.getValue().getBalance();
					balance = balance + amount;
					map.replace(i.getValue().getAcc_No(), i.setValue(bankClass.setBalance(balance)));
					System.out.println("Updated balance after deposite in acc-no: " + i.getKey() + " : " + balance);
					break;
				}
			}

		}
		if (flag == 0) {
			System.out.println("UserId not found");
		}
	}

	public void withdraw(String userId, double amount) {

		int flag = 0;

		for (Entry<Long, BankClass> i : map.entrySet()) {
			for (Entry<Long, BankUserClass> j : map1.entrySet()) {
				if (i.getValue().getAcc_No() == j.getValue().getAcc_No() && j.getValue().getUser_Id().equals(userId)) {
					flag = 1;
					if (i.getValue().getBalance() < amount) {
						System.out.println("Insuficient Balance");
						break;
					} else {
						balance = i.getValue().getBalance();
						balance = balance - amount;
						map.replace(i.getValue().getAcc_No(), i.setValue(bankClass.setBalance(balance)));
						System.out.println("Updated balance after withdraw in acc_no: " + i.getKey() + " : " + balance);
						break;
					}
				}
			}
		}
		if (flag == 0) {
			System.out.println("UserId not found");
		}

	}

	public void viewBalance(String userId) {
		int flag = 0;
		for (Entry<Long, BankClass> i : map.entrySet()) {
			for (Entry<Long, BankUserClass> j : map1.entrySet()) {
				if (i.getValue().getAcc_No() == j.getValue().getAcc_No() && j.getValue().getUser_Id().equals(userId)) {
					flag = 1;
					System.out.println("Balance: " + i.getValue().getBalance());
					break;
				}

			}

		}
		if (flag == 0) {
			System.out.println("UserId not found");
		}

	}

//	public void transfer(String userId) {
//
//		System.out.print("Enter the account no. to transfer: ");
//		long acc_No = scan.nextLong();
//		double amount = 0;
//		int flag = 0;
//		for (Entry<Long, BankClass> i : map.entrySet()) {
//			if (i.getKey() == acc_No) {
//				System.out.print("Enter amount to transfer: ");
//				amount = scan.nextDouble();
//				for (Entry<Long, BankUserClass> j : map1.entrySet()) {
//					if (i.getValue().getAcc_No() == j.getValue().getAcc_No()) {
//						flag = 1;
//						
//						withdraw(userId, amount);
////						System.out.println("Updated balance after transfer: " + balance);
//						
//						deposite(j.getValue().getUser_Id(), amount);
////						System.out.println("Updated balance for acc number " + acc_No + " : " + balance);		
//						break;
//					}
//				}
//			}
//		}
//		if (flag == 0) {
//			System.out.println("Account number not found");
//		}
//
//	}
}