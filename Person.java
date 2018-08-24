/**
 * Assign1.java
 * Andy Ta
 * CST8132
 * Lab 5/Assignment 
 * Anu Thomas/Angela Giddings
 */
/**
 * This class contains the constructor for the Person object
 * @author Andy
 * @version 6.0
 * @see java.util.Scanner
 */
public class Person {
	/**
	 * stores first name of person 
	 */
	String firstName;
	/**
	 * stores last name of person
	 */
	String lastName;
	/**
	 * store email of person 
	 */
	String email;
	/**
	 * stores phone number of person 
	 */
	String phoneNumber;
	
	/**
	 * Class constructor of person 
	 * @param firstName used to initialize firstName variable
	 * @param lastName used to initialize lastName variable
	 * @param email used to initialize email variable 
	 * @param phoneNumber used to initialize phoneNumber varibale
	 */
	Person(String firstName, String lastName, String email, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

}
