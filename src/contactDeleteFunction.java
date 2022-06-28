import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

import static java.nio.file.Files.lines;
import static java.nio.file.Files.readAllLines;

public class contactDeleteFunction {
    public static void main(String[] args) throws IOException {
        Input in = new Input();
        Path filePath = Paths.get("data", "contacts-list.txt");

        try {
            lines = Files.readAllLines(filePath);
            String delete = in.getString("Who's contact do you want to delete?");
            Files.write(filePath, Arrays.asList(delete));
            Files.deleteIfExists(Path.of("util: contacts-list.txt"));
            lines.clear(delete);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
