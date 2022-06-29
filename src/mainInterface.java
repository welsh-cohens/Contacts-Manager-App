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

    static Scanner scanner = new Scanner(System.in);

    public static void Interface() throws IOException {
        Input in = new Input();
        Path filepath = Paths.get("data", "contacts-list.txt");
        List<String> contactsList = Files.readAllLines(filepath);
        List<String> lines;
        List<Contacts> contacts = new ArrayList<>();

        System.out.println("1. View Contacts\n2. Add New Contact\n3. Search Contact By Name\n4. Delete Existing Contact\n5. Exit\nEnter An Option (1, 2, 3, 4, or 5:)");
        int viewContacts = Integer.parseInt(scanner.nextLine());
        if (viewContacts == 1) {
            for (int i = 0; i < contactsList.size(); i += 1) {
                System.out.println((i + 1) + ": " + contactsList.get(i));
            }
        }
        int addContact = Integer.parseInt((scanner.nextLine()));
        if (addContact == 2) {

        }
        public class addContact {
                try {
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
            } catch(
            IOException e)

            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Interface();


    }
}
