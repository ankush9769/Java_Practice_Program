package NIOadvance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NIOadvance {
    static void main() throws IOException {
        String content = Files.readString(Path.of("src/Employee.txt"));
        System.out.println(content);
    }
}
