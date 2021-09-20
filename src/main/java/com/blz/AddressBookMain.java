package com.blz;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AddressBookMain {
    private Map<String, Contacts> addressBook = new TreeMap<String, Contacts>();

    public void addContactToAddressBook(Contacts contact) {
        addressBook.put(contact.getFullName(), contact);
    }

    public void displayAddressBook() {
        for (Map.Entry<String, Contacts> contact : addressBook.entrySet()) {
            System.out.println(contact.getValue());
        }
    }

    public void editContact(String fullName) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        for (Map.Entry<String, Contacts> contact : addressBook.entrySet()) {
            if (fullName.toUpperCase().equals((contact.getKey()).toUpperCase())) {
                System.out.println("Which you want to edit: ");
                System.out.println("1. Address");
                System.out.println("2. City");
                System.out.println("3. State");
                System.out.println("4. Zip");
                System.out.println("5. Phone Number");
                System.out.println("6. Email");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        contact.getValue().setAddress(sc.next());
                        break;
                    case 2:
                        contact.getValue().setCity(sc.next());
                        break;
                    case 3:
                        contact.getValue().setState(sc.next());
                        break;
                    case 4:
                        contact.getValue().setZip(sc.nextInt());
                        break;
                    case 5:
                        contact.getValue().setPhoneNumber(sc.next());
                        break;
                    case 6:
                        contact.getValue().setEmail(sc.next());
                        break;
                    default:
                        System.out.println("Invaild choice");
                }
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println("Contact doesn't Exist");
        sc.close();
    }

    public Contacts createContact() {
        Scanner sc = new Scanner(System.in);

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
        String phoneNumber = sc.next();

        System.out.println("Enter email address:");
        String email = sc.next();
        sc.close();
        Contacts contact = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);

        return contact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBookMain addressBookObject = new AddressBookMain();

        Contacts givenContact = new Contacts("Toshita", "C.", "Abc Residency", "Dombivli", "MH", 421202, "9118282002", "xyz.abc@gmail.com");
        addressBookObject.addContactToAddressBook(givenContact);

        System.out.println("1. Add Contact \n2. Edit Contact\n ");
        System.out.println("Enter your choice: ");
        int select = sc.nextInt();
        switch (select) {
            case 1:
                Contacts contact = addressBookObject.createContact();
                addressBookObject.addContactToAddressBook(contact);
                break;
            case 2:
                System.out.println("Enter Fullname: ");
                String fullName = sc.nextLine();
                addressBookObject.editContact(fullName);
                break;
            default:
                System.out.println("Invalid choice");
        }
        addressBookObject.displayAddressBook();
        sc.close();
    }
}

