package controller;

import service.AuthenticationService;
import view.login.LoginWindow;

import javax.swing.*;

public class LoginController {
    private LoginWindow window;
    private AuthenticationService authenticationService;

    public LoginController(){
        this.window = new LoginWindow();
        this.authenticationService = new AuthenticationService();
        this.window.getLoginBtn().addActionListener(e-> handleLoginBtnAction());
        this.window.getSignupBtn().addActionListener(e-> handleSignUpBtnAction());
    }

    public void handleLoginBtnAction(){
        String username = this.window.getUserName();
        String password = this.window.getPassword();
        try {
            this.authenticationService.loginWithUsername(username, password);

        }catch (Exception e){
            JOptionPane.showMessageDialog(this.window, e.getMessage());
        }
    }

    public void handleSignUpBtnAction(){
        new EmployeeCreateController();
    }
}
