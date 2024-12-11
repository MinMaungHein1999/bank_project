package util.mapper;

import dto.AccountDto;
import model.Account;
import model.AccountStatus;
import model.Customer;
import model.Employee;

public class AccountConverter {

    public static Account convertToAccount(AccountDto accountDto){

        Employee testEmployee = new Employee();
        testEmployee.setId(1);


        Customer testCustomer = new Customer();
        testCustomer.setId(2);
        testCustomer.setEmail("blltspd@gmail.com");
        testCustomer.setCreatedBy(testEmployee);

        Account account = new Account();
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType().getValue());
        account.setCurrency(accountDto.getCurrency());;
        account.setStatus(AccountStatus.ACTIVE);
        account.setCurrency(accountDto.getCurrency());
        account.setBalance(accountDto.getAmount());
        account.setCreatedBy(testEmployee);
        account.setUpdatedBy(testEmployee);
        account.setCustomer(testCustomer);
        account.setPassword(PasswordUtil.encryptPassword(accountDto.getPassword()));
        return  account;
    }

}
