package com.blz;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
    static HashMap<String, AddressBook> addressBookMap = new HashMap<>();

    public static void createAddressBook() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to add new address book? (Y / N)");
        if (sc.nextLine().equals("Y")) {
            do {
                System.out.println("Enter the Address Book");
                String bookName = sc.nextLine();
                addressBookMap.put(bookName, new AddressBook("bookName"));
                System.out.println("Continue: (Y/N)");
            } while (sc.nextLine().equals("Y"));
        }
    }

    public static void main(String[] args) {
        createAddressBook();
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name  of address book you want to access: ");
        String addressBookName = sc.nextLine();
        do {
            System.out.println("1. Create and Add Contact \n2. Edit Contact\n3. Delete Contact");
            System.out.println("Enter your choice: ");
            int select = sc.nextInt();

            switch (select) {
                case 1:
                    System.out.println("Enter the details of Contact:\nEnter 1.)Address Book 2019 \t 2.)Address Book 2020");
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
                    addressBookMap.get(addressBookName).addContact(contact);
                    break;
                case 2:
                    System.out.println("Enter Full Name: ");
                    String fullName = sc.nextLine();
                    addressBookMap.get(addressBookName).editContact(fullName);
                    break;
                case 3:
                    System.out.println("Enter the Full Name : ");
                    String name = sc.nextLine();
                    addressBookMap.get(addressBookName).deleteContact(name);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("Do you want Continue or Add new Contact(Y/N)");
        } while (sc.nextLine().equals("Y"));
    }
}
