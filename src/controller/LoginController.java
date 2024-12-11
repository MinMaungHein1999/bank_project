package controller;

import dao.abs.branch.BranchDaoImpl;
import model.Branch;
import service.AuthenticationService;
import view.login.LoginWindow;

import javax.swing.*;

public class LoginController {
    private LoginWindow window;
    private AuthenticationService authenticationService;
    private BranchDaoImpl branchDao;

    public LoginController(){
        this.window = new LoginWindow();
        this.branchDao = new BranchDaoImpl();

        Branch[] branches = this.branchDao.getAll().toArray(new Branch[0]);
        for(Branch branch : branches){
            this.window.getBranches().addItem(branch);
        }
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
