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

import static java.nio.file.Files.lines;
import static java.nio.file.Files.readAllLines;

public class contactDeleteFunction {
    public static void main(String[] args) throws IOException {
        Input in = new Input();
        Path filePath = Paths.get("data", "contacts-list.txt");

        try {
            String delete = in.getString("Who's contact do you want to delete?");
            List <String> contactsList = Files.readAllLines(filePath);
            for (int i = 0; i <= contactsList.size(); i++) {
                if (Objects.equals(contactsList.get(i), delete)) {
                    Files.readAllLines(filePath).remove(contactsList);
                }else {
                    Files.write(filePath, contactsList, StandardOpenOption.APPEND);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
