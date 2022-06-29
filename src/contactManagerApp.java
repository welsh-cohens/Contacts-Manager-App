import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class contactManagerApp {

    public static Path contactsFilePath = Paths.get("data", "contacts-list.txt");
//    public static List <String> contactsList = Files.readAllLines(contactsFilePath);


    public static void renderContacts() throws IOException {
//        Path contactsPath = Paths.get("data", "contacts-list.txt");
        List<String> contactsList = Files.readAllLines(contactsFilePath);
        for (int i = 0; i < contactsList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactsList.get(i));
        }
    }

    public static void addContact() {
        Input in = new Input();
        List<String> lines;
        List<Contacts> contacts = new ArrayList<>();
        try {
            lines = Files.readAllLines(contactsFilePath);
            for (String line : lines) {
                String[] splitStr = line.split("/|");
                contacts.add(new Contacts (splitStr[0], splitStr[1]));
            }
            String person = in.getString("Add Contact Name");
            String digits = in.getString("Add dem digits");
            String fullContact = String.format("%s | %s", person, digits);
            Files.write(contactsFilePath, Arrays.asList(fullContact), StandardOpenOption.APPEND);
            lines.add(fullContact);
            contacts.add(new Contacts(person, digits));
        }   catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteContact() throws IOException {
        Input in = new Input();
        try {
            List <String> contactsList = Files.readAllLines(contactsFilePath);
            List <String> updatedList = new ArrayList<>();
            String userInput = in.getString("Who's contact will you want to delete?");
            for (String line : contactsList)
            Files.write(contactsFilePath, contactsList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        renderContacts();
        deleteContact();
        renderContacts();

    }
}
