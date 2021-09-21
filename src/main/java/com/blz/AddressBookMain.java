package com.blz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {
    static HashMap<String,AddressBook> addressBookMap = new HashMap<>();
    public static void createAddressBook( ) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to add new address book? (Y / N)");
        if (sc.nextLine().equals("Y")) {
            do {
                System.out.println("Enter the Address Book");
                String bookName = sc.nextLine();
                addressBookMap.put(bookName, new AddressBook("bookName"));
                System.out.println("Continue: (Y/N)");
            } while(sc.nextLine().equals("Y"));
        }
    }

    public static void searchPersonByCity (String name, String city) {
        List<Contacts> list = new ArrayList<Contacts>();
        for (Map.Entry<String, AddressBook> entries : addressBookMap.entrySet()) {
            list = entries.getValue().getAddressBook().stream().filter(p -> p.getCity().equals(city)).filter(p ->(p.getFirstName() + p.getLastName()).equals(name)).collect(Collectors.toList());
        }
        for (Contacts contact : list) {
            System.out.println(contact);
        }
    }

    public static void searchPersonByState(String name, String state) {
        List<Contacts> list = new ArrayList<Contacts>();
        for(Map.Entry<String, AddressBook> entries : addressBookMap.entrySet()) {
            list = entries.getValue().getAddressBook().stream().filter(p -> p.getState().equals(state)).filter(p ->(p.getFirstName() + p.getLastName()).equals(name)).collect(Collectors.toList());
        }
        for(Contacts contact : list) {
            System.out.println(contact);
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

            switch(select) {
                case 1: System.out.println("Enter the details of Contact");
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
                    sc.nextLine();
                    Contacts contact = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
                    addressBookMap.get(addressBookName).addContact(contact);
                    break;
                case 2: System.out.println("Enter Full Name: ");
                    String fullName = sc.nextLine();
                    addressBookMap.get(addressBookName).editContact(fullName);
                    break;
                case 3: System.out.println("Enter the Full Name : ");
                    String name = sc.nextLine();
                    addressBookMap.get(addressBookName).deleteContact(name);
                    break;
                default:System.out.println("Invalid choice");
            }
            System.out.println("Do you want Continue or Add new Contact(Y/N)");
        } while(sc.nextLine().equals("Y"));
    }
}