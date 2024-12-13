package util;

public class TokenUtil {
    public static String encrypteToken(String loginInfo){
        return Encrypter.toHashStr(loginInfo);
    }
}
