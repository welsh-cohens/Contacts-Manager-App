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
        List <String> contactsList = Files.readAllLines(filePath);
        List<String> updatedList = new ArrayList<>();

        try {
            String delete = in.getString("Who's contact do you want to delete?");
            for (String line : contactsList) {
                if (line.contains(delete)) {
                    updatedList.add("");
                    continue;
                }
                updatedList.add(line);
                Files.write(filePath, updatedList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
