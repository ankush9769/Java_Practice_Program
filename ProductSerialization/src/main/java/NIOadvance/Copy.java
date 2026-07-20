package NIOadvance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Copy {
    static void main() throws IOException {
        Files.copy(Path.of("src/Employee.txt"),Path.of("src/backup.txt"));
    }
}
