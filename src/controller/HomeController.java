package controller;

import model.Employee;
import policy.EmployeePolicy;
import view.home.HomeWindow;

public class HomeController extends BaseController{
    private static HomeWindow homeWindow = new HomeWindow();

    public HomeController(){
        super(homeWindow);
        initBtnsActions();

    }

    public void initBtnsActions(){
        homeWindow.setCardManagementBtnAction(e -> handleCardManagementAction());
        homeWindow.setEmployeeManagementBtnAction(e -> handleEmployeeManagementAction());
        homeWindow.setTransactionManagementBtn(e -> handleTransactionManagementAction());
        homeWindow.setAccountManagementBtnAction(e -> handleAccountManagementAction());
    }

    private void handleAccountManagementAction() {
        new AccountListController();
    }

    private void handleTransactionManagementAction() {
        new AccountTransactionController();
    }

    private void handleEmployeeManagementAction() {
        EmployeePolicy policy = new EmployeePolicy();
        policy.canNew(null, this.currentUser);
        new EmployeeCreateController();
    }

    private void handleCardManagementAction() {

    }
}
