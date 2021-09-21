package com.blz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    Scanner sc = new Scanner(System.in);

    private ArrayList<Contacts> contactArray;
    private Map<String,Contacts> contactMap;

    public AddressBook() {
        contactArray = new ArrayList<>();
        contactMap = new HashMap<>();
    }

    public List<Contacts> getcontactArray() {
        return contactArray;
    }

    public Map<String, Contacts> getcontactMap() {
        return contactMap;
    }

    public void addNewContact () {
        //Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Name: ");
        String firstName = sc.nextLine();
        for(int i=1; i>0; i++) {
            if(duplicateEntryValidation(firstName))
                continue;
            else
                break;
        }
        System.out.println("Enter Last Name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter Phone Number: ");
        long phoneNumber = sc.nextLong();
        System.out.println("Enter Address: ");
        String address = sc.next();
        System.out.println("Enter City: ");
        String city = sc.next();
        System.out.println("Enter State: ");
        String state = sc.next();
        System.out.println("Enter pinCode: ");
        int zip = sc.nextInt();
        System.out.println("Enter EmailId: ");
        String email = sc.next();
        Contacts conObj = new Contacts(firstName, lastName, phoneNumber, address, city, state, zip, email);
        contactArray.add(conObj);
        contactMap.put(firstName, conObj);
    }

    public void editContact() {
        System.out.println("Enter The First Name whose contact details is to be edited: ");
        String firstname = sc.nextLine();
        Contacts conObj = contactMap.get(firstname);
        System.out.println("Enter the PhoneNumber: ");
        long number = sc.nextLong();
        conObj.setPhoneNumber(number);
        System.out.println("Enter the Address: ");
        String address = sc.next();
        conObj.setAddress(address);
        System.out.println("Enter the City: ");
        String city = sc.next();
        conObj.setCity(city);
        System.out.println("Enter the State: ");
        String state = sc.next();
        conObj.setState(state);
        System.out.println("Enter the Zip: ");
        int zip = sc.nextInt();
        conObj.setZip(zip);
        System.out.println("Enter the Email: ");
        String email = sc.next();
        conObj.setEmail(email);
    }

    public void deleteContact() {
        System.out.println("Enter The First Name to delete: ");
        String name = sc.nextLine();
        Contacts obj = contactMap.get(name);
        contactArray.remove(obj);
    }

    public void  multipleAddressBook() {
        for(int i = 1; i > 0; i++) {
            System.out.println("\n1. Add \n2. Edit \n3. Delete \n4. Exit");
            System.out.println("\nEnter your choice");
            int select = sc.nextInt();
            switch(select) {
                case 1:	addNewContact();
                    break;
                case 2:	if(contactArray.size() == 0)
                    System.out.println("Please Enter the contact");
                else
                    editContact();
                    break;
                case 3:	if(contactArray.size() == 0)
                    System.out.println("Plese Enter the contact");
                else
                    deleteContact();
                    break;
                case 4:	System.exit(0);
                    break;
            }
        }
    }

    public boolean duplicateEntryValidation(String name) {
        for (Contacts entry : contactArray) {
            if (entry.getFirstName().equals(name)) {
                System.out.println("Name already exist");
                return true;
            }
        }
        return false;
    }

    public void printContact() {
        System.out.println(contactArray);
    }
}