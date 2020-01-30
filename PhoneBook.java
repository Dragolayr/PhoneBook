package phonebook;

import java.util.Scanner;
import java.util.Arrays;
public class PhoneBook {

	public static void main(String[] args) {
		
	
		Scanner in = new Scanner(System.in);
		
		Person [] contactList = new Person[0];
		boolean again = true;
		while (again) {
			
			System.out.println("Hello! Please choose from the following options: ");
			System.out.println("1: Add new entry");
			System.out.println("2: Search for existing entry");
			System.out.println("3: Search by first name");
			System.out.println("4: Search by last name");
			System.out.println("5: Search by full name");
			System.out.println("6: Search by telephone number");
			System.out.println("7: Search a city");
			System.out.println("8: Search a state");
			System.out.println("9: Delete a record for a given telephone number");
			System.out.println("10: Update a record for a given telephone number");
			System.out.println("11: Show all records in ascending order");
			System.out.println("12: Exit the program");
			
			int choice = in.nextInt();
			
			switch (choice) {
			
			case 1:
				Person newPerson = addContact();
				contactList = Person.expandArray(contactList, newPerson);
	
				break;
																																
			case 2: 
				searchContact(contactList);         
				
				break;
				
			case 3: 
				searchFirstName(contactList);

				break;
			case 4: 
				enterLastName(contactList);

				break;			
			case 5: 
				enterFullName(contactList);

				break;
			case 6: 
				enterPhoneNum(contactList);

				break;
			case 7: 
				enterCity(contactList);

				break;
			case 8:
				enterState(contactList);
				break;
			case 9: 
				contactList = enterPhoneNumToDeleteRecord(contactList);    // DONT FORGE TO SAVE AND UPATE!
				
				break;
			case 10: 
				updatePhoneNum(contactList);
				break;
			
			case 11: 
				sortAscending(contactList);
				
				break;
			
			case 12: 
				programExit();
				
			}
		}
		


	}

	private static Person addContact() {
		System.out.println("\nPlease add name to add to Phone Book: ");
		Scanner in = new Scanner(System.in); //scan in name from user
		String input = in.nextLine();
		
		String [] newContact = input.split(",");  // converts the input into an array 
		
		String names = newContact[0];
		String street = newContact[1].substring(1);
		String city = newContact[2].substring(1);		//these detail what the value is at each index from 0 - 5
		String state = newContact[3].substring(1);
		String zipcode = newContact[4].substring(1);
		String phoneNum = newContact[5].substring(1).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");  //this formats the phone number to have dashes

		String firstName;
		String lastName;    // this is to break apart the name to output and save the necessary format for the assignment
		String middleName = " ";
		String [] wholeName = names.split(" ");    // this takes the entirety of the name and puts it in the correct format--SPLITS IT
		String fullName = names;
		if(wholeName.length == 2) {
			firstName = wholeName[0]; // this is saying that the first name is WHAT IS AT INDEX 0. 
			lastName = wholeName[wholeName.length-1]; //this is saying the last name is found at the END OF THE ARRAY OF THE WHOLE NAME minus 1.
		}
		else if(wholeName.length > 2) {  // this is saying if the whole name has more than 2 parts to it ex: john E doe (like a middle name)
			firstName = wholeName[0];
			lastName = wholeName[wholeName.length-1];
			for(int i = 0; i < wholeName.length; i ++) { //this is supposed to get the middle name. takes the whole name and if its not equal to the 
				if(i != 0 && i != wholeName.length -1) {    // position of the first or last name it designates it the middle name.
					middleName += wholeName[i];
					if(i != wholeName.length - 2) {
						middleName += " ";
					}
				}											
				
			}
		
		}
		firstName = wholeName[0];
		lastName = wholeName[wholeName.length-1];
		
		
		
		Address address = new Address(street, city, state, zipcode );
		Person person = new Person(firstName, middleName, lastName, address, phoneNum);  

		return person;
		
	}	
	
	
	
		private static void searchContact(Person [] search) {
			System.out.println("\nWho are we searching for? ");
			Scanner input = new Scanner(System.in);
			String input1 = input.next();
			for(int i=0; i < search.length; i ++) {

				if(search[i].getFirstName().equalsIgnoreCase(input1)){
					System.out.println(search[i].toString());    
				}
			}
		}
		private static void searchFirstName(Person [] searchFirstName) {
			
			System.out.println("\nPlease enter a first name: ");
			Scanner input = new Scanner(System.in);
			String input1 = input.next();
			for(int i=0; i < searchFirstName.length; i ++) {
				if(searchFirstName[i].getFirstName().equalsIgnoreCase(input1)){
					System.out.println(searchFirstName[i].toString());     
				}
			}
			
			
		}
		private static void enterLastName(Person [] searchLastName) {
			System.out.println("\nPlease enter a last name: ");
			Scanner input = new Scanner(System.in);
			String input1 = input.next();
			for(int i=0; i < searchLastName.length; i ++) {
				if(searchLastName[i].getLastName().equalsIgnoreCase(input1)){
					System.out.println(searchLastName[i].toString());     
				}
			}
			
		}
		private static void enterFullName(Person[] searchFullName) {
			System.out.println("\nPlease enter the full name: ");
			Scanner input = new Scanner(System.in);
			String input1 = input.next();
			for(int i=0; i < searchFullName.length; i ++) {
				if(searchFullName[i].getFullName().equalsIgnoreCase(input1)){
					System.out.println(searchFullName[i].toString());     
				}
			}
		}
		private static void enterPhoneNum(Person[] searchPhoneNum) {
			System.out.println("\nPlease enter a phone number: ");
			Scanner input = new Scanner(System.in);
			String input1 = input.next();
			for(int i=0; i < searchPhoneNum.length; i ++) {
				if(searchPhoneNum[i].getPhoneNum().contains(input1)){
					System.out.println(searchPhoneNum[i].toString());     
				}
			}
			
		}
		private static void enterCity(Person[] searchCity) {
			System.out.println("\nPlease enter a city: ");
			Scanner input = new Scanner(System.in);
			String input1 = input.nextLine();
			for(int i=0; i < searchCity.length; i ++) {
				System.out.println(searchCity[i].getAddress().getCity().equalsIgnoreCase(input1));
				if(searchCity[i].getAddress().getCity().equalsIgnoreCase(input1)){
					System.out.println(searchCity[i].getFullName()+ " " +searchCity[i].getAddress());     
				}
			}
			
		}
		private static void enterState(Person[] searchState) {
			System.out.println("\nPlease enter a state: ");
			Scanner input = new Scanner(System.in);
			String input1 = input.next();
			for(int i=0; i < searchState.length; i ++) {

				if(searchState[i].getAddress().getState().equalsIgnoreCase(input1)){
					System.out.println(searchState[i].getFullName()+ " " +searchState[i].getAddress());     
				}
			}
			
		}
		private static void updatePhoneNum(Person[] searchPhoneNum) {
			System.out.println("\nPlease enter an existing phone number to update: ");
			Scanner input = new Scanner(System.in);
			String input1 = input.next();
			for(int  i = 0; i < searchPhoneNum.length; i ++) {
				System.out.println(searchPhoneNum[i].getPhoneNum().contentEquals(input1));
				if(searchPhoneNum[i].getPhoneNum().contentEquals(input1)) {
					System.out.println("What is the new number? ");
					String input2 = input.next();
					searchPhoneNum[i].setPhoneNum(input2);
				}
			}
			
			
		}
		private static Person [] enterPhoneNumToDeleteRecord(Person[] contactList) {
			System.out.println("\nEnter a phone number to delete a record");
			Scanner in = new Scanner(System.in);
			
			Person [] delContact = new Person[0];
			
			String delPhoneNum = in.next();
			
			for(int i = 0; i < contactList.length; i ++) {

				if(!contactList[i].getPhoneNum().equals(delPhoneNum)) {
					
					delContact = Person.addPerson(delContact,contactList[i]);
				}
			}
			System.out.println("You have deleted the contact.");
			
			return delContact;
		}
		
		public static void sortAscending(Person[] contactList) {
			
			Person [] contactListAscOrder = contactList;
			for(int i = 0; i<contactListAscOrder.length; i++) {
				Arrays.sort(contactListAscOrder, Person.PersonNameCompare);
				System.out.println(contactListAscOrder[i] + "\n");
				}
			
		}
		
		
		
		
		
		
		private static void programExit() {
		
				System.exit(0);
			}
		
		
		
		
		
		}







