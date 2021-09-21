package com.blz;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
    static int option = 0;
    public static void main(String[] args) {
        AddressBook[] addressBook = new AddressBook[2];
        addressBook[0] = new AddressBook("Address Book 2019");
        addressBook[1] = new AddressBook("Address Book 2020");
        Scanner sc = new Scanner(System.in);
        HashMap<String,AddressBook> addressBookMap = new HashMap<>();
        addressBookMap.put("Address Book 2019", addressBook[0]);
        addressBookMap.put("Address Book 2020", addressBook[1]);
        do {
            sc.nextLine();
            System.out.println("1. Create and Add Contact \n2. Edit Contact\n3. Delete Contact");
            System.out.println("Enter your choice: ");
            int select = sc.nextInt();

            switch(select) {
                case 1: System.out.println("Enter the details of Contact:\nEnter 1.)Address Book 2019 \t 2.)Address Book 2020");
                    option = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter First Name:");
                    String firstName = sc.next();
                    System.out.println("Enter Last Name:");
                    String lastName = sc.next();
                    System.out.println("Enter address:");
                    String address = sc.next();
                    System.out.println("Enter city:");
                    String city = sc.next();
                    System.out.println("Enter state:");
                    String state = sc.next();
                    System.out.println("Enter zip code:");
                    int zip = sc.nextInt();
                    System.out.println("Enter phone No.:");
                    long phoneNumber = sc.nextLong();
                    System.out.println("Enter email address:");
                    String email = sc.nextLine();
                    Contacts contact = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
                    if (option == 1)
                        addressBook[0].addContact(contact);
                    else
                        addressBook[1].addContact(contact);
                    break;
                case 2: System.out.println("Enter Fullname: ");
                    String fullName = sc.nextLine();
                    if (option == 1)
                        addressBook[0].editContact(fullName);
                    else
                        addressBook[1].editContact(fullName);
                    break;
                case 3: System.out.println("Enter the Full Name : ");
                    String name = sc.nextLine();
                    if(option == 1)
                        addressBook[0].deleteContact(name);
                    else
                        addressBook[1].deleteContact(name);
                    break;
                default:System.out.println("Invalid choice");
            }
            System.out.println("Do you want Continue or Add new Contact(Y/N)");
        }while(sc.next().charAt(0) == 'Y');
        System.out.println("All Contacts in Address Book 2019: ");
        System.out.println(addressBook[0].getAddressBook());
        System.out.println("All Contacts in Address Book 2020: ");
        System.out.println(addressBook[1].getAddressBook());
    }
}