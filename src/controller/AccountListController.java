package controller;

import dao.abs.account.AccountDao;
import dao.abs.account.AccountDaoImpl;
import model.Account;
import service.AccountService;
import view.accounts.AccountListWindow;

import java.util.List;

public class AccountListController {

    private final AccountService ACCOUNT_SERVICE;
    private final AccountListWindow ACCOUNT_LIST_WINDOW;

    public AccountListController(){
        this.ACCOUNT_SERVICE = new AccountService();
        this.ACCOUNT_LIST_WINDOW = new AccountListWindow();
        this.ACCOUNT_LIST_WINDOW.setTableData(prepareAccountData());

    }

    public String[][] prepareAccountData(){
        int columnCount = this.ACCOUNT_LIST_WINDOW.getCOLUMN_NAMES().length;
        List<Account> accountList = this.ACCOUNT_SERVICE.getAllAccounts();
        String[][] dataTable = new String[accountList.size()][columnCount];
        for(int i = 0; i <accountList.size(); i++ ) {
                dataTable[i] =  accountList.get(i).prepareDataForAccountList();
        }

        return dataTable;
    }

}
