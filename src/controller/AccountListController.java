package controller;

import dao.abs.account.AccountDao;
import dao.abs.account.AccountDaoImpl;
import view.accounts.AccountListWindow;

public class AccountListController {

    private final AccountDao ACCOUNT_DAO;
    private final AccountListWindow ACCOUNT_LIST_WINDOW;

    public AccountListController(){
        this.ACCOUNT_LIST_WINDOW = new AccountListWindow();
        this.ACCOUNT_DAO = new AccountDaoImpl();
    }

    public String[][] prepareAccountData(){
        int columnCount = this.ACCOUNT_LIST_WINDOW.getCOLUMN_NAMES().length;

        return null;
    }

}
