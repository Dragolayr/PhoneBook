package phonebook;
import java.util.Comparator;
import java.util.Scanner;

public class Person implements Comparator{
	
	private String firstName;
	private String middleName;
	private String lastName;     // this is ENCAPSULATION----the variables declared are made as private. 
	private String phoneNum;	// the getters and setters below allow us to change the values of these variables.
	private Address address;
	private String fullName;	//ENCAPSULATION MAKES SURE THAT SENSITIVE DATA IS HIDDEN FROM USERS.
	
	public Person () {}
	
	public String getFullName() {
		if(middleName != null) {
			return firstName+ " " + middleName +" "+ lastName;
		}else{return firstName+ " "+ lastName;}
		
	}

	public void setFullName(String fullName) {
		
		this.fullName = firstName+middleName+lastName;
	}

	public Person(String firstName, String middleName, String lastName, Address address, String phoneNum) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;    //this is constructing an object
		this.address = address;
		this.middleName= middleName;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
//	String [] person = {};


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String toString() {
		return ""+firstName+""+middleName+" "+lastName+","+address+", "+phoneNum+"";    
	}

	public static Person [] expandArray(Person [] newContact, Person person) {
		Person [] newContactList = new Person[newContact.length +1];
		for(int i = 0; i < newContact.length; i ++) {
			newContactList[i] = newContact[i];
		}
		newContactList[newContact.length] = person; 
		
		return newContactList;
			
	}
	public static void printArray(String [] newContactList) {
		for(int i = 0; i< newContactList.length; i++) {

			System.out.println(newContactList[i]);
		}
	}

	public static Person[] addPerson(Person[] source, Person person) {

		//initialize the new array
		// new array in the original array + 1 more spot
		Person[] newList = new Person[source.length +1];

		//loop through OG array
		for(int i=0;i<source.length;i++) {

		/*the new arrays index element is the same as the old
		ones*/

			newList[i]=source[i];
		}

		newList[source.length] = person; 

		System.out.println("Inside method addPerson: " + newList.toString() +"\n");

		return newList;
	
	}
	
	
	public static Comparator<Person> PersonNameCompare= new Comparator<Person>() {
    

		public int compare(Person person1, Person person2) {

			String personname1 = person1.getFirstName().toUpperCase();
			String personname2 = person2.getFirstName().toUpperCase();

			//ascending order
			return personname1.compareTo(personname2);


		}

		};
	}
