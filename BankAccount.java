import java.util.Scanner;
/**
 * Assign1.java
 * Andy Ta
 * CST8132
 * Lab 5/Assignment 
 * Anu Thomas/Angela Giddings
 */
/**
 * This acts as the super class of all bankAccounts
 * @author Andy
 * @version 6.0
 * @see java.util.Scanner
 */
public abstract class BankAccount {
	/*
	 * accHolder stores the Person attributes
	 */
	protected Person accHolder;
	/**
	 * stores the opening balance of the account
	 */
	protected double openingBalance;
	/**
	 * stores the account number of each account
	 */
	protected int accNumber;
	/**
	 * default, no arguement constructor
	 */
	BankAccount(){	
	}
	
	/**
	 * Class constructor that initilizes the bank account
	 * @param accHolder creates the Person object into accHolder, than passes that into bankAccount
	 * @param openingBalance intilizes openingBalace instance variable
	 * @param accNumber initilizes accNumber instance variable 
	 */
	public BankAccount(Person accHolder,double openingBalance,int accNumber) {
		this.accHolder=accHolder;
		this.openingBalance=openingBalance;
		this.accNumber=accNumber;
	}
	
	/**
	 * 
	 * @param accts accepts the array of BankAccount
	 * @param index accepts an int to use as the index, to manipulate individual accounts in the array
	 * @param trans accepts an int to use as the transaction value 
	 * @return the updated opening balance of the account 
	 */
	public double updateBalance(BankAccount[] accts,int index,double trans) {
		 double x = accts[index].openingBalance+trans;
			openingBalance =x;
			return openingBalance;
	 }
	/**
	 * This method overwrites the toString method to print object variables
	 */
	@Override
	 public String toString() {
		 return "\nAccountNumber: "+accNumber+" Name: "+accHolder.firstName+" "+accHolder.lastName+" Phone Number: "+accHolder.phoneNumber+"\n"+"Email: "+
					accHolder.email+" Balance: "+openingBalance+"\n";
	 }
	/**
	 * abstract method that is defined in the child classes 
	 */
	abstract void monthlyUpdate();
	
	/**
	 * Method that asks the user information to create person object and parts of bankAccount
	 * @return will return true if all information is valid, will continue on initilizing classes
	 */
	public boolean addBankAccount() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter first name of account holder");
		String fName = input.nextLine();
		//checks to see if there are numbers in the name, using a for loop to check each character
		for(int i=0;i<fName.length();i++) {
			if(Character.isDigit(fName.charAt(i))) {
				System.out.println("No numbers allowed in name");
				return false;
			}	
		}
		
		System.out.println("Enter last name of account holder");
		String lName = input.nextLine();
		//checks to see if there are numbers in the name, using a for loop to check each character
		for(int i=0;i<lName.length();i++) {
			if(Character.isDigit(lName.charAt(i))) {
				System.out.println("No numbers allowed in last name");
				return false;
			}
		}
		
		System.out.println("Enter phone number");
		String phone = input.nextLine();
		int length = String.valueOf(phone).length();
		//checks to see if phone number is correct length and has no letters
		for(int i=0;i<phone.length();i++) {
			if(Character.isLetter(phone.charAt(i))) {
				System.out.println("No letter allowed in phone number");
				return false;
			}
		}
		if(length>12) {
			System.out.println("Your phone number is not valid, it must be below 12 numbers");
			return false;
		}
		
		System.out.println("Enter email address");
		String email = input.nextLine();
		//checks to see if email contains an "@" and "." character
		if(!(email.contains("@")) || !(email.contains("."))){
			System.out.println("Invalid email, must contain @ and . ");
			return false;
		}
		//checks to see if "@" character is before the "."
		else if(email.indexOf("@")>email.indexOf(".")) {
			System.out.println("Invalid email format ");
			return false;
		}
		
		//assigns those variables to the accHolder variable 
		accHolder = new Person(fName,lName,email,phone);
		
		System.out.println("Enter opening balance");
		double opBal = input.nextDouble();
		if(opBal>1) {
			this.openingBalance=opBal;
			return true;
		}else {
			System.out.println("Balance cannot be negative");
			return false;
		}
		
	}

}
