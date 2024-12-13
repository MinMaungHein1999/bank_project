package controller;

import exception.AutheticationFailException;
import model.Employee;
import service.AuthenticationService;

import javax.swing.*;

public class BaseController {
    private JFrame baseWindow;
    private AuthenticationService authenticationService;
    public Employee currentUser;

    public BaseController(JFrame baseWindow){
        this.baseWindow = baseWindow;
        this.authenticationService = new AuthenticationService();
        authenticateLoginUser();
        this.currentUser = AuthenticationService.currentUser;
    }

    public void authenticateLoginUser(){
        try {
            this.authenticationService.authenticate();
        }catch (AutheticationFailException e){
            JOptionPane.showMessageDialog(this.baseWindow, e.getMessage());
            this.baseWindow.dispose();
            new LoginController();
        }
    }
}
