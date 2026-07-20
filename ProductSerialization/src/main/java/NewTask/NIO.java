package NewTask;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.logging.Logger;

public class NIO {
    static void main()throws IOException {
        Path path = Path.of("src/Employee.txt");
        try(FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)){
            //TODO:it will opne the file for reading operation"
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //TODO: create memory to load data"
            while(channel.read(buffer)>0){
                //TODO: copies data from file into buffer"
                buffer.flip();
                //TODO: while writting from the file into buffer its position moves the end of thhe buffer, so befor reading we must call flip() to bring the cusor to the beginning of buffer . without buffer.flip() ther will be bo data becouse the position will be at the end"
                while (buffer.hasRemaining()){
                    //TODO:reads bytes from the buffer one by one"
                    System.out.println((char)buffer.get());
                }
            }
            buffer.clear();
            //TODO: clear the buffer so that it can filled again"
        }
    }
}
