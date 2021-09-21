package com.blz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    public String name;

    public AddressBook(String name) {
        this.name = name;
    }

    public Contacts contact;
    public ArrayList<Contacts> addressBook = new ArrayList<Contacts>();

    public Contacts getContact() {
        return contact;
    }

    public void setContact(Contacts contact) {
        this.contact = contact;
    }

    public ArrayList<Contacts> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(ArrayList<Contacts> addressBook) {
        this.addressBook = addressBook;
    }

    public void addContact(Contacts contact) {
        addressBook.add(contact);
    }

    public void editContact(String name) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String str = "";
        for (Contacts contact : addressBook) {
            str = contact.getFirstName() + contact.getLastName();
            if (name.equals(str)) {
                System.out.println("What you want to edit/change: ");
                System.out.println("1. Address");
                System.out.println("2. City");
                System.out.println("3. State");
                System.out.println("4. Zip");
                System.out.println("5. Phone Number");
                System.out.println("6. Email");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter new address");
                        String address = sc.nextLine();
                        contact.setAddress(address);
                        break;
                    case 2:
                        System.out.println("Enter new city");
                        String city = sc.nextLine();
                        contact.setCity(city);
                        break;
                    case 3:
                        System.out.println("Enter new state");
                        String state = sc.nextLine();
                        contact.setAddress(state);
                        break;
                    case 4:
                        System.out.println("Enter new ZIP code");
                        int zip = sc.nextInt();
                        contact.setZip(zip);
                        sc.nextLine();
                        break;
                    case 5:
                        System.out.println("Enter new Phone Number");
                        long phone = sc.nextLong();
                        sc.nextLine();
                        contact.setPhoneNumber(phone);
                        break;
                    case 6:
                        System.out.println("Enter new Email id");
                        String email = sc.nextLine();
                        contact.setEmail(email);
                        break;
                }
            } else
                System.out.println("Invalid Contact");

        }
    }

    public void deleteContact(String name) {
        String str1 = "";
        for (Contacts contact : addressBook) {
            str1 = contact.getFirstName() + contact.getLastName();
            if (name.equals(str1))
                addressBook.remove(contact);
        }
    }
}