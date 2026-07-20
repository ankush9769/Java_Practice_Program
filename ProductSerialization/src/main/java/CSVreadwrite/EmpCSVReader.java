package CSVreadwrite;

import NewTask.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmpCSVReader {
    static void main() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("src/emp.csv"))){

            String line;
            while((line = reader.readLine())!=null){
                String[] arr = line.split(",");
                Employee e = new Employee(Integer.parseInt(arr[1]),arr[0],Double.parseDouble(arr[2]));
                System.out.println(e);
            }
        }
    }
}
