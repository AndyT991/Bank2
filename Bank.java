import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Assign1.java
 * Andy Ta
 * CST8132
 * Lab 5/Assignment 
 * Anu Thomas/Angela Giddings
 */
/**
 * This class holds the array of Bank Accounts and calls the methods in chequing and savings
 * @author Andy
 * @version 6.0
 * @see java.util.Scanner
 */

public class Bank {
	/**
	 * stores the user input
	 */
	String userIn;
	/**
	 * stores objects of BankAccount into an array
	 */
	BankAccount[] arrayOfAccounts;
	/**
	 * acts as a counter variable that increases by one, everytime a account is created
	 */
	private int numAccounts = 0;

	Scanner input = new Scanner(System.in);
	/**
	 * No arguement constructor that calls the overloaded constructor
	 */
	public Bank() {
		this(1000);
	}
	/**
	 * Overloaded constructor that initilizes arrayOfAccounts
	 * @param size passes an int value to initilize the size of the array 
	 */
	public Bank(int size) {
		arrayOfAccounts = new BankAccount[size];
	}
	/**
	 * Method that creates the bankAccount objects and adds them into arrayOfAccounts
	 * @return either true or false depending if an object is created and added to the array 
	 */
	public boolean addAccount() {
		try {
		String in;
		char aType;
		int accNum;
		//checks to see if array is full
		if (numAccounts >= arrayOfAccounts.length - 1) {
			System.out.println("System is full");
			return false;
		}
		//prompts user to enter c or s, if user enters anything else, it will print "Invalid input" and return to main 
		System.out.println("Enter details of account holder " + (numAccounts + 1));
		System.out.println("Enter S for savings or C for chequings");
		
		in = input.nextLine();
		
		if(in.length()>1) {
			System.out.println("Please enter one character");
			return false;
		}
		
		aType = in.charAt(0);
		
		if (!(aType==('s')) && !(aType==('c'))) {
			System.out.println("Invalid input, must enter c or s");
			return false;
		}
		//declares a variable of type BankAccount
		BankAccount myAcc;
		
		//depending on user input will either execute to create savings account or chequings account
		//also contains exception handling, will return if account number is already used and if account number size is valid 
		if (aType==('s')||aType==('S')) {
			myAcc = new SavingsAccount();
			System.out.println("Enter account number");
			accNum = input.nextInt();
			if(accNum > 99999999 || accNum < 0) {
				System.out.println("Number must be under 8 digits and under and not negative");
				return false;
			}
			//if checkAccountNumber returns false, it means acc number does not exist and can be used
			if(!checkAccountNumber(accNum)) {
				myAcc.accNumber = accNum;
			}else {
				System.out.println("Account number used");
				input.nextLine();
				return false;
			}

		} else if (aType=='c'||aType=='C') {
			myAcc = new ChequingAccount();
			System.out.println("Enter account number");
			accNum = input.nextInt();
			
			if(accNum > 99999999|| accNum <0) {
				System.out.println("Number must be under 8 digits and and not be negative");
				input.nextLine();
				return false;
			}
			
			//if checkAccountNumber returns false, it means acc number does not exist and can be used
			if(!checkAccountNumber(accNum)) {
				myAcc.accNumber = accNum;
			}else {
				System.out.println("Account number used");
				input.nextLine();
				return false;
			}
		}
		else {
			input.nextLine();
			return false;
		}
		//if addBankAccount returns true it puts the object into the array 
		//if not it will return false
		if (myAcc.addBankAccount()) {
			arrayOfAccounts[numAccounts] = myAcc;
			numAccounts++;
			input.nextLine();
			return true;
		}
		input.nextLine();
		return false;
		
		}catch(InputMismatchException ie) {
			System.out.println("Not a valid number");
			input.nextLine();
			return false;
		}
	}
	/**
	 * Method that updates the individual accounts by adding the transaction value
	 */
	public void updateAccount() {
		try {
		int index = 0;
		
		//Prompts user to enter account number
		System.out.println("Enter account number");
		int accNum = input.nextInt();
		
		//this calls the checkAccountNumber method, which will double check if account number is duplicate
		if(checkAccountNumber(accNum)) {
			System.out.println("Enter amount to deposit/withdraw(positive number to deposit, negative number to withdraw)");
			double transaction = input.nextDouble();
			
			// findAccount method is called, an variable "index" is now initilized with the index of the account number
			index = findAccount(accNum);
			
			//double checks if account has enough funds
			if(transaction+arrayOfAccounts[index].openingBalance < 1) {
				System.out.println("Error insufficient funds");
				input.nextLine();
				return;
			}
			//calls the updateBalance method in bankAccount, with verified index and transaction amount
			arrayOfAccounts[index].updateBalance(arrayOfAccounts, index, transaction);
		
		//if account is not found it will return to main menu, telling user "Account doesnt exist"	
		}else {
			System.out.println("Account doesnt exist");
			input.nextLine();
			return;
		}
		}catch(InputMismatchException ie) {
			System.out.println("Must enter valid numbers");
			input.nextLine();
			return;
		}
	}
	/**
	 * Finds the index of the account 
	 * @param aNum passes the account number
	 * @return index of the account number passed into the arguement
	 */
	public int findAccount(int aNum) {
		int index = 0;
		//will check all objects inside array
		for (int i=0;i<numAccounts;i++) {
			//if matching account number appears, return the index value
			if (arrayOfAccounts[i].accNumber == aNum) {
				index = i;
			}
		}
		return index;
	}
	/**
	 * Displays individual account 
	 */
	public void displayAccount() {
		try {
		System.out.println("Enter account number");
		int num = input.nextInt();
		//checks to see if Account number exist
		if(checkAccountNumber(num)) {
			//gets index 
			int index = findAccount(num);
			//saves toString output into x , than prints x 
			String x = arrayOfAccounts[index].toString();
			System.out.print(x);
			
		
		//if account number entered does not exist it will return to main 
		}else {
			System.out.println("Account number doesnt exist"); 
			input.nextLine();
			return;
		}
		}catch(InputMismatchException ie) {
			System.out.println("Invalid input !");
			input.nextLine();
			return;
		}
	}
	/**
	 * Method used to print all account within array
	 */
	public void printAllAccounts() {
		//checks to see if array is empty, if it is prints statement and returns
		if(arrayOfAccounts[0]==null) {
			System.out.println("There are no accounts to print");
			//input.nextLine();
			return;
		}
		//runs through an array and prints evey account
		for (int i=0;i<numAccounts;i++) {
			String x = arrayOfAccounts[i].toString();
			System.out.println(x);
		}
	}
	/**
	 * Method used to update every account, according to fees or interest
	 */
	public void monthlyUpdate() {
		//checks to see if array is empty, if it is prints statement and returns
		if(arrayOfAccounts[0] == null) {
			System.out.println("No accounts to update");
			return;
		}
		//calls monthly update for every account
		System.out.println("Accounts have been updated");
		for (int i=0;i<numAccounts;i++) {
			arrayOfAccounts[i].monthlyUpdate();
		}
		
	}
	/**
	 * Method used to check if account number exists 
	 * @param acc accepts an account number as an arguement and sees if it matches any account
	 * @return if account number already exists, it will return true, if not it will return false
	 */
	public boolean checkAccountNumber(int acc) {
		for(int i=0;i<numAccounts;i++) {
			if(acc==arrayOfAccounts[i].accNumber) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Method checks if balance is valid for a withdraw
	 * @param index accepts an int as a index to the arrayOfAccounts, 
	 * @param trans accepts an int as a transaction
	 * @return either true or false, if transaction will cause a negative balance it will return false
	 */
	public boolean checkBalance(int index,double trans) {
		if(arrayOfAccounts[index].openingBalance<trans) {
			System.out.println("Error insufficient funds");
			return false;
		}
		return true;
	}

}
