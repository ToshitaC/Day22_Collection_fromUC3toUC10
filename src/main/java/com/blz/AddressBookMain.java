package com.blz;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class AddressBookMain {
    private static Map<String, AddressBook> addressMap = new TreeMap<>();
    public static Map<String, Contacts> cityToContactEntryMap = new TreeMap<>();
    public static Map<String, Contacts> stateToContactEntryMap = new TreeMap<>();

    static Scanner sc = new Scanner(System.in);

    public void addNewAddressBook() {
        AddressBook object = new AddressBook();
        System.out.println("Enter the name of the address book: ");
        String bookName = sc.next();
        addressMap.put(bookName,object);
        object.multipleAddressBook();
    }

    public static void displayContactsByCityGrouping() {
        Set<String> listOfcity = cityToContactEntryMap.keySet();
        for(String cityName : listOfcity) {
            System.out.println("The Address book entries based on city: " + cityName);
            personSearch(cityName);
        }
    }

    public static void displayContactsByStateGrouping() {
        Set<String> listOfstate = stateToContactEntryMap.keySet();
        for(String stateName : listOfstate) {
            System.out.println("The Address book entries based on state: " + stateName);
            personSearch(stateName);
        }
    }

    public void displayAddressBooks() {
        System.out.println("\nThe Address Books Added are: ");
        addressMap.forEach((key, value) -> System.out.println(key + "\n"));
    }

    public static void numberByCity() {
        Set<String> listOfCity = cityToContactEntryMap.keySet();
        for(String cityName : listOfCity) {
            Contacts contactNumber = cityToContactEntryMap.get(cityName);
            System.out.println("Number of Contacts from city " + cityName + " " + ((Map<String, AddressBookMain>) contactNumber).size());
        }
    }

    public static void numberByState() {
        Set<String> listOfState = stateToContactEntryMap.keySet();
        for(String stateName : listOfState) {
            Contacts contactNumber = stateToContactEntryMap.get(stateName);
            System.out.println("Number of Contacts from state " + stateName + " " + ((Map<String, AddressBookMain>)contactNumber).size());
        }
    }

    public static void personSearch(String search) {
        int numOfPerson = 0;
        Iterator contactArray = addressMap.entrySet().iterator();
        while(contactArray.hasNext()) {
            Map.Entry entry=(Map.Entry) contactArray.next();
            AddressBook address = (AddressBook)entry.getValue();
            List<Contacts> list = address.getcontactArray();
            for(Contacts conObj : list) {
                if(conObj.getCity().equals(search) || conObj.getState().equals(search))	{
                    System.out.println(conObj);
                    numOfPerson++;
                }
            }
            if(numOfPerson == 0)
                System.out.println("Not found");
        }
    }

    @SuppressWarnings("unused")
    public static void main(String args[]) {
        AddressBookMain addressBook = new AddressBookMain();
        for(int i=0; i >= 0; i++) {
            System.out.println("\n1.Adding a Address Book:: \n2.Searching for a Person \n3. View Contacts grouped by city \n4. View Contacts grouped by state \n");
            System.out.print("5. Number of contacts according to city \n6. Number of contacts according to state");
            System.out.println("\n Enter Your Choice:");
            int select = sc.nextInt();
            switch(select) {
                case 1: while (true) {
                    AddressBook obj = new AddressBook();
                    System.out.println("Enter name for address Book: ");
                    String name = sc.next();
                    if (AddressBookMain.addressMap.containsKey(name)) {
                        System.out.println("\nDuplicate Address Book Entry not allowed \n");
                        continue;
                    }
                    else {
                        AddressBookMain.addressMap.put(name, obj);
                        System.out.println("\n  Address Book : " + name);
                        obj.multipleAddressBook();
                        break;
                    }
                }
                    break;

                case 2:	System.out.println("Enter City or State for searching a person");
                    String search = sc.next();
                    AddressBookMain.personSearch(search);
                    break;

                case 3:	displayContactsByCityGrouping();
                    break;
                case 4:	displayContactsByStateGrouping();
                    break;
                case 5:	numberByCity();
                    break;
                case 6:	numberByState();
                    break;
                default: System.out.println("Invalid");
            }
        }
    }
}