import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import util.*;

public class mainInterface {

    static Input in = new Input();
    static Path filepath = Paths.get("data", "contacts-list.txt");
    static Scanner scanner = new Scanner(System.in);

    //Display Contacts Method
    public static void displayContacts() {
        List<String> lines;
        List<Contacts> contacts = new ArrayList<>();

        try {
            List<String> contactsList = Files.readAllLines(filepath);
            for (int i = 0; i < contactsList.size(); i += 1) {
                System.out.println((i + 1) + ": " + contactsList.get(i));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Add Contacts Method
    public static void addContact() {
        List<String> lines;
        List<Contacts> contacts = new ArrayList<>();

        try {
            List<String> contactsList = Files.readAllLines(filepath);
            lines = Files.readAllLines(filepath);
            for (String line : lines) {
                String[] splitStr = line.split("/|");
                contacts.add(new Contacts(splitStr[0], splitStr[0]));
            }
            String person = in.getString("Add Contact Name");
            String digits = in.getString("Add dem digits");
            String fullContact = String.format("%s | %s", person, digits);
            Files.write(filepath, Arrays.asList(fullContact), StandardOpenOption.APPEND);
            lines.add(fullContact);
            contacts.add(new Contacts(person, digits));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    //Search Contacts Method
    public static void searchContacts() {
        try {
            List<String> contactsList = Files.readAllLines(filepath);
            String searchName = in.getString("Enter Name to Search");
            for (String line : contactsList) {
                if (line.contains(searchName)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Delete Contacts Method
    public static void deleteContacts() {
        try {
            List <String> contactsList = Files.readAllLines(filepath);
            List<String> updatedList = new ArrayList<>();
            String deletedName = in.getString("Who's contact do you want to delete?");
            for (String line : contactsList) {
                if (line.contains(deletedName)) {
                    updatedList.add("");
                    continue;
                }
                updatedList.add(line);
                Files.write(filepath, updatedList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Interface() throws IOException {
        System.out.println("1. View Contacts\n2. Add New Contact\n3. Search Contact By Name\n4. Delete Existing Contact\n5. Exit\nEnter An Option (1, 2, 3, 4, or 5:)");


        }

    public static void main(String[] args) throws IOException {
        Interface();



    }
}
