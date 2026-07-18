import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandling {

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/Employee.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found or unable to read.");
            System.out.println(e.getMessage());
        }
    }
}