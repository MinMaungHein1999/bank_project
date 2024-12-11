package service;

import exception.PasswordsDontMatchException;

public class CheckPasswordsService {

    public CheckPasswordsService() {

    }

    public void isPasswordEquals(String password, String confirmPassword) throws PasswordsDontMatchException {
        if (!password.equals(confirmPassword)) {
            throw new PasswordsDontMatchException("Password and Confirm Password do not match.");
        }
    }

}
