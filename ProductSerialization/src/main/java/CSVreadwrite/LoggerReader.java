package CSVreadwrite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoggerReader {
    static void main() throws IOException {

        try(BufferedReader buffer = new BufferedReader(new FileReader("src/Logger.txt"))){
            String line;
            int countINFO =0;
            int countWARN =0;
            int countERROR =0;
            while((line= buffer.readLine())!=null){
                if(line.startsWith("INFO")){
                    countINFO++;
                } else if (line.startsWith("ERROR")) {
                    countERROR++;
                } else if (line.startsWith("WARN")) {
                    countWARN++;
                }

            }
            System.out.println("INFO ="+countINFO);
            System.out.println("ERROR ="+countERROR);
            System.out.println("WARN ="+countWARN);
        }

    }
}
