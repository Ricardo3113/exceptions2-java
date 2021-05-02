package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Account;
import exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		
		try {
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account acc = new Account(number, name, initialBalance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();		
			acc.withdraw(amount);
			System.out.printf("New balance: %.2f%n", acc.getBalance());			
		}	
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}		
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}		
		sc.close();
	}
}