package model;

import java.sql.Date;

public class Account {
    private int id;
    private String accountNumber;
    private int accountType;
    private double balance;
    private String currency;
    private String password;
    private AccountStatus status;
    private Date cratedAt;
    private Date updatedAt;
    private Date confirmedAt;
    private Employee CreatedBy;


    private Employee updatedBy;
    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public Date getCratedAt() {
        return cratedAt;
    }

    public void setCratedAt(Date cratedAt) {
        this.cratedAt = cratedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(Date confirmedAt) {
        this.confirmedAt = confirmedAt;
    }


    public Employee getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(Employee createdBy) {
        CreatedBy = createdBy;
    }

    public Employee getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Employee updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String[] prepareDataForAccountList(){
        String[] dataArray = new String[6];
        dataArray[0] = String.valueOf(this.id);
        dataArray[1] = this.accountNumber;
        dataArray[2] = this.customer.getFirstName() + " " + this.customer.getLastName();
        dataArray[3] = AccountType.fromInt(this.accountType).toString();
        dataArray[4] = this.currency;
        dataArray[5] = String.valueOf(this.balance);
        return dataArray;
    }

}
