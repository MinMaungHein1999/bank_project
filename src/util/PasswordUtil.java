package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtil {

    public static String encryptPassword(String password){
        return Encrypter.toHashStr(password);
    }
}
