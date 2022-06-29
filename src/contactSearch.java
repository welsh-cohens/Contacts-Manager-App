import util.Input;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class contactSearch {
    public static void main(String[] args) throws IOException {
        Input in = new Input();
        Path filePath = Paths.get("data", "contacts-list.txt");

        List <String> contactsList = Files.readAllLines(filePath);
        System.out.println(contactsList);

        String searchName = in.getString("Enter Name to Search");
        for (String line : contactsList) {
            if (line.contains(searchName)) {
                System.out.println(line);
            }
        }


    }
}
