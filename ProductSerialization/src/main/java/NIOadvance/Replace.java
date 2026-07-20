package NIOadvance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class Replace {
    static void main()throws IOException {
        Files.copy(Path.of("src/Employee.txt"),Path.of("src/backup.txt"), StandardCopyOption.REPLACE_EXISTING);
    }
}
