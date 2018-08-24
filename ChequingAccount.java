import java.util.Scanner;
/**
 * Assign1.java
 * Andy Ta
 * CST8132
 * Lab 5/Assignment 
 * Anu Thomas/Angela Giddings
 */
/**
 * This class extends BankAccount is used to create a chequings account
 * @author Andy
 * @version 6.0
 * @see java.util.Scanner
 */
public class ChequingAccount extends BankAccount {
	/**
	 * stores the monthlyFee of the ChequingAccount
	 */
	private double monthlyFee;
	
	/**
	 * default no arguement constructor 
	 */
	ChequingAccount(){
	}
	/**
	 * Class constructor that calls the super constructor and initilizes all fields
	 * @param user Person object is required to create an instance of BankAccount
	 * @param opBal initilizes opening balance
	 * @param accNumber initlizes account number
	 * @param monthlyFee initlizes monthly fee
	 */
	ChequingAccount(Person user,double opBal,int accNumber,double monthlyFee){
		super(user,opBal,accNumber);
		this.monthlyFee=monthlyFee;
	}
	
	/**
	 * Method used to update the balance by performing the monthly fee deduction
	 */
	@Override
	void monthlyUpdate() {
		double newBal = this.openingBalance-this.monthlyFee;
		this.openingBalance=newBal;
	}
	
	/**
	 * Method that calls the addBankAccount method using super, to initilize variables 
	 */
	@Override
	public boolean addBankAccount() {
		
		Scanner input = new Scanner(System.in);
		
		if(super.addBankAccount()) {
		System.out.println("Enter monthly fee");
		double monFee = input.nextDouble();
		this.monthlyFee=monFee;
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
		return super.toString()+"Fee: "+monthlyFee+"\n";
	}

}
