import java.util.Scanner;
/**
 * Assign1.java
 * Andy Ta
 * CST8132
 * Lab 5/Assignment 
 * Anu Thomas/Angela Giddings
 */
/**
 * This class extends BankAccount and is used to create a savings account
 * @author Andy
 * @version 6.0
 * @see java.util.Scanner
 */

public class SavingsAccount extends BankAccount {
	/**
	 * variable used to store interest rate
	 */
	private double interestRate;
	/**
	 * variable used to store minimum balance 
	 */
	private double minimumBalance;
	
	/**
	 * default no argument constructor 
	 */
	SavingsAccount(){	
	}
	
	/**
	 * Class constructor that calls the super constructor and initilizes all fields
	 * @param accHolder Person object is required to create an instance of BankAccount
	 * @param openingBalance initlizes opening balance of Bank account 
	 * @param accNumber initlizes account number
	 * @param interestRate initlizes interest rate 
	 * @param minimumBalance initilizes minimum balance
	 */
	SavingsAccount(Person accHolder,double openingBalance, int accNumber,double interestRate,double minimumBalance){
		super(accHolder,openingBalance,accNumber);
		this.interestRate=interestRate;
		this.minimumBalance=minimumBalance;
	}
	/**
	 * method that updates balance by adding interest to balance
	 */
	@Override
	public void monthlyUpdate() {
		if(this.openingBalance<this.minimumBalance) {
			System.out.println("Error for account number "+this.accNumber+" balance less than minimum, interest will not be added");
			return;
		}
		double interest = this.openingBalance*this.interestRate;
		double newBal = this.openingBalance + interest;
		this.openingBalance = newBal;
	}
	/**
	 * Method that calls the addBankAccount method using super, to initilize variables
	 */
	@Override
	public boolean addBankAccount() {
		Scanner input = new Scanner(System.in);
		
		if(super.addBankAccount()) {
		System.out.println("Enter minimum balance");
		double minBal = input.nextDouble();
		if(minBal>this.openingBalance) {
			System.out.println("Error balance is less than minimum");
			input.nextLine();
			return false;
		}
		System.out.println("Enter interest rate (should be a number under 1)");
		double intRate = input.nextDouble();
		if(intRate>1) {
			System.out.println("Interest Rate is not realistic");
			return false;
		}
		this.minimumBalance=minBal;
		this.interestRate=intRate;
		input.nextLine();
		return true;
		}else {
			return false;
		}
	}
	/**
	 * method used to format printing of toString
	 */
	@Override
	public String toString() {
		return super.toString()+ "Minimum balance: "+minimumBalance+" Interest Rate: "+interestRate+"\n";
	}
	

}
