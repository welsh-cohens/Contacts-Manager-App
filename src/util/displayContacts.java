package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class displayContacts {
    public static void main(String[] args) throws IOException {

        Path contactsPath = Paths.get("data", "contacts-list.txt");
        List<String> contactsList = Files.readAllLines(contactsPath);

        for (int i = 0; i < contactsList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactsList.get(i));
        }

    }
}
