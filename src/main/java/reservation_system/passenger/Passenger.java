package reservation_system.passenger;

//Importing the abstract User class
import reservation_system.user.User;

/**
 * Represents a Passenger in the Railway Reservation System.
 * Inherits common user properties from the User class.
 */

public class Passenger extends User
{
	// Unique ID to identify each passenger
	private int passengerId;
	
	/*
     * Constructor to initialize Passenger details.
     * Calls the constructor of the superclass User to set name, age, and gender.
     */
	
	public Passenger(String name,int age,String gender,int passengerId)
	{
		// Calls the constructor of the abstract User class
		super(name,age,gender);
		 this.passengerId = passengerId;
	}
	
	/*
      * Getter method for the passenger ID.
    */
	public int getPassengerId()
	{
		return passengerId;
	}
	
	/*
     * This method overrides the abstract method in the User class.
     * It displays the passenger's information in a formatted manner.
    */
	@Override
	 public void showUserInfo() 
	{
        System.out.println("\nPassenger ID: " + passengerId);
        System.out.println("\nName: " + name);
        System.out.println("\nAge: " + age);
        System.out.println("\nGender: " + gender);
    }
}
