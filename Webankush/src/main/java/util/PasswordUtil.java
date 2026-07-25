package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {
    private static final String SALT = "jdbc";
    public static String hash(String password){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashed = digest.digest((SALT + password).getBytes(StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder();
            for(byte value : hashed){
                builder.append(String.format("%02x",value));
            }
            return builder.toString();
        }catch (NoSuchAlgorithmException exception){
            throw new IllegalStateException("SHA-256 is not available",exception);
        }
    }
}
