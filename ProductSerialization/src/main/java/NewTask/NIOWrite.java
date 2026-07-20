package NewTask;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NIOWrite {
    static void main() throws IOException {
        Path path = Path.of("src/Employee2.txt");
        try(FileChannel channel = FileChannel.open(path, StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,StandardOpenOption.TRUNCATE_EXISTING))
        {
            String msg = "chaliye \n shuru \n karte \n hai";
            ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
            channel.write(byteBuffer);


        }

    }
}
