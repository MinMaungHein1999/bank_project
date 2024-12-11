package service;

import dao.abs.account.AccountDao;
import dao.abs.account.AccountDaoImpl;
import dto.AccountDto;
import exception.AccountCreateException;
import model.Account;
import model.AccountStatus;
import model.Customer;
import model.Employee;
import util.mapper.AccountConverter;

import java.util.List;

public class AccountService {

    private AccountDao accountDao;

    //private customerDao cus
    public AccountService(){
        this.accountDao = new AccountDaoImpl();
    }

    public Account createAccount(AccountDto accountDto) throws AccountCreateException {

        Employee testEmployee = AuthenticationService.currentUser;

        // Get customer from AccountDto.

        Account account = new Account();
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType().getValue());
        account.setCurrency(accountDto.getCurrency());;
        account.setStatus(AccountStatus.ACTIVE);
        account.setCurrency(accountDto.getCurrency());
        account.setBalance(accountDto.getAmount());
        account.setCreatedBy(testEmployee);
        account.setUpdatedBy(testEmployee);
        account.setCustomer(null);
        this.accountDao.create(account);
        return accountDao.findByAccountNumber(accountDto.getAccountNumber());
    }

    public Account createAccountTesting(AccountDto accountDto){

        // For the time being, I'll pass the dummy data to test that OTP works.
        Account convertedAccount = AccountConverter.convertToAccount(accountDto);
        this.accountDao.create(convertedAccount);
        System.out.println(convertedAccount.getCustomer().getEmail());
        //return accountDao.findByAccountNumber(accountDto.getAccountNumber());
        return convertedAccount;
    }

    public List<Account> getAllAccounts(){
        return  this.accountDao.getAll();
    }

    public void deleteAccount(int accountId){
        this.accountDao.delete(accountId);
    }

    public void confirmAccount(Account account){
        this.accountDao.updateConfirmedAt(account);
    }

}
