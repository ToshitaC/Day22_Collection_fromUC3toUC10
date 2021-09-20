package com.blz;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class AddressBookMain {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        do {
            sc.nextLine();
            System.out.println("1. Create and Add Contact \n2. Edit Contact\n3. Delete Contact");
            System.out.println("Enter your choice: ");
            int select = sc.nextInt();

            switch(select) {
                case 1: System.out.println("Enter First Name:");
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
                    addressBook.addContact(contact);
                    break;
                case 2: System.out.println("Enter Fullname: ");
                    String fullName = sc.nextLine();
                    addressBook.editContact(fullName);
                    break;
                case 3: System.out.println("Enter the Full Name : ");
                    String name = sc.nextLine();
                    addressBook.deleteContact(name);
                    break;
                default: System.out.println("Invalid choice");
            }
            System.out.println("Do you want Continue or Add new Contact(Y/N)");
        }while(sc.next().charAt(0) == 'Y');
        ArrayList<Contacts> contactList = addressBook.getAddressBook();
        for (Contacts contact : contactList) {
            System.out.println(contact);
        }
    }
}