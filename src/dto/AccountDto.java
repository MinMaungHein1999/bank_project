package dto;

import model.AccountType;
import model.Customer;

public class AccountDto {
    private String accountNumber;
    private AccountType accountType;
    private String currency;
    private double amount;
    private int customerId;
    private String password;
    private String confirmPassword;
    private Customer customer;

    public AccountDto() {

    }

    public AccountDto(String accountNumber, AccountType accountType, String currency, double amount, int customerId, String password, String confirmPassword, Customer customer) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.currency = currency;
        this.amount = amount;
        this.customerId = customerId;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.customer = new Customer();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
