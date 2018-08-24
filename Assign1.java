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
 * This class contains the main method, which contains the main menu of the program 
 * @author Andy
 * @version 6.0
 * @see java.util.Scanner
 * @see java.util.InputMismatchException
 */

public class Assign1 {
	/**
	 * The main method contains the main menu of the program and prompts the user with options
	 * @param args Command line arguments. UNUSED. 
	 */
	public static void main(String[] args) {
		String in;
		char option;

		Scanner input = new Scanner(System.in);
		Bank TD = new Bank();
		//do while loop will keep asking questions until user inputs 'q' to quit
		do {
			
			System.out.println("======================================");
			System.out.println("Welcome to banking simulator");
			System.out.println("a: Add new account");
			System.out.println("u: Update an account");
			System.out.println("d: Display an account");
			System.out.println("p: Print all accounts");
			System.out.println("m: Run monthly update");
			System.out.println("q: Quit");
			
			in = input.nextLine();
			
			if(in.length()>1) {
				System.out.println("Please enter one character");
				option = '?';
				continue;
			}
			//this exists beccause a string out of bounds excpetion will occur if no input is entered
			if(in.isEmpty()) {
				System.out.println("Error");
				option ='?';
				continue;
			}
			
			option = in.charAt(0);
			
			try {		
			if (option =='a'||option=='A') {
				TD.addAccount();

			} else if (option == 'u'||option=='B') {
				TD.updateAccount();

			} else if (option == 'd'||option=='D') {
				TD.displayAccount();

			} else if (option == 'p'||option=='P') {
				TD.printAllAccounts();

			} else if (option == 'm'||option=='M') {
				TD.monthlyUpdate();

			} else if(option == 'q'||option=='Q') {
				break;
			}
			else {
				System.out.println();
				System.out.println("Try again");
			}
			
			}catch(NullPointerException ne) {
				System.out.println("Not found");
			}catch(InputMismatchException ie) {
				System.out.println("Invalid input type");
			}catch(StringIndexOutOfBoundsException se) {
				System.out.println("Error");
			}
			
		} while (option != 'q'||option !='Q');
		
	}

}
