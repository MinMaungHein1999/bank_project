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
        homeWindow.setCustomerManagementBtnAction(e -> hadleCustomerManagementAction());
    }

    private void hadleCustomerManagementAction() {
        new CustomerCreateController();
    }

    private void handleAccountManagementAction() {
        new AccountListController();
    }

    private void handleTransactionManagementAction() {
        new AccountTransactionController();
    }

    private void handleEmployeeManagementAction() {
        new EmployeeCreateController();
    }

    private void handleCardManagementAction() {

    }
}
