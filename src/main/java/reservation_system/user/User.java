package reservation_system.user;

//Abstract base class to represent a generic User
public abstract class User 
{
 // Protected fields to store user's name, age, and gender
 protected String name;
 protected int age;
 protected String gender;
 
 // Parameterized Constructor
  public User(String name, int age, String gender)
  {
	super();
	this.name = name;
	this.age = age;
	this.gender = gender;
}

// Getter method for user's name.
 public String getName() 
 {
     return name;
 }

 // Setter method for user's name.
 public void setName(String name) 
 {
     this.name = name;
 }

 // Getter method for user's age.
 public int getAge() 
 {
     return age;
 }

 // Setter method for user's age.
public void setAge(int age) 
{
     this.age = age;
 }

  //Getter method for user's gender.
 public String getGender() 
 {
     return gender;
 }
 
  //Setter method for user's gender.
public void setGender(String gender) 
{
     this.gender = gender;
 }

 /*
  * Abstract method to be implemented by subclasses.
  * This should display or return specific user information.
  */
 public abstract void showUserInfo();
}
