package NIOadvance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Move {
    static void main() throws IOException {
        Files.move(Path.of("src/abc.txt"),Path.of("src/moving folder/abc2.txt"));
    }
}
