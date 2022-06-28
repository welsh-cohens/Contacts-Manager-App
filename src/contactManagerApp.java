import jdk.dynalink.StandardOperation;
import util.Input;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class contactManagerApp {
    public static void main(String[] args) throws IOException {
        Input in = new Input();
        Path filepath = Paths.get("data", "contacts-list.txt");
        List<String> lines;
        List<Contacts> contacts = new ArrayList<>();
        //Why did imported files correct error?
        try {
            lines = Files.readAllLines(filepath);
            for (String line : lines) {
                String[] splitStr = line.split("\\|");
                contacts.add(new Contacts (splitStr[0], splitStr[1]));
            }
            String person = in.getString("Add Contact Name");
            String digits = in.getString("Add dem digits");
            String fullContact = String.format("%s | %s", person, digits);
            Files.write(filepath, Arrays.asList(fullContact), StandardOpenOption.APPEND);
            lines.add(fullContact);
            contacts.add(new Contacts(person, digits));


        }
    }
}
