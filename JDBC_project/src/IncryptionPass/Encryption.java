package IncryptionPass;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Encryption {

    public static String encrypt(String input) throws Exception{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");//admin
        byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

        StringBuilder builder = new StringBuilder();
        for(byte b : hash){
            builder.append(String.format("%02x",b));
        }
        return builder.toString();
    }
    public static void main() throws Exception {
        String value = "corepassword";
        String hashedvalue = encrypt(value);

        System.out.println("Original:"+value);
        System.out.println("SHA-256:"+hashedvalue);

    }
}
