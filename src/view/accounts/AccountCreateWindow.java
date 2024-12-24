package view.accounts;

import dto.AccountDto;
import exception.AccountCreateException;
import model.AccountType;
import service.AccountService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountCreateWindow extends JFrame {


    private JLabel accountNumberLabel;
    private JLabel accountTypeLabel;
    private JLabel currencyLabel;
    private JLabel amountLabel;
    private JLabel customerIdLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;

    private JTextField accountNumberInput;
    private JTextField amountInput;
    private JTextField customerIdInput;

    private JPasswordField passwordInput;
    private JPasswordField confirmPasswordInput;

    private JComboBox<AccountType> accountTypeCombo;
    private JComboBox<String> currencyCombo;

    private JButton saveButton;
    private JButton clearButton;

    public AccountCreateWindow(){
        initializeComponents();
        layoutComponents();
    }

    private void initializeComponents(){
        this.setTitle("Create Account");
        //Need to encapsulate currency
        String[] currencyList = new String[]{"MMK", "THB", "USD", "JPY"};

        this.accountNumberLabel =  new JLabel("Account number:");
        this.accountTypeLabel = new JLabel("Account type:");
        this.currencyLabel =  new JLabel("Currency");
        this.amountLabel = new JLabel("Amount:");
        this.customerIdLabel = new JLabel("Customer ID:");
        this.passwordLabel = new JLabel("Password:");
        this.confirmPasswordLabel =  new JLabel("Confirm password:");

        this.accountNumberInput =  new JTextField(20);
        this.amountInput =new JTextField(20);
        this.customerIdInput = new JTextField(20);

        this.passwordInput = new JPasswordField(20);
        this.confirmPasswordInput =  new JPasswordField(20);

        this.accountTypeCombo = new JComboBox<>(AccountType.values());
        this.currencyCombo = new JComboBox<>(currencyList);

        this.saveButton = new JButton("Save");
        this.clearButton = new JButton("Clear");
        this.setSize(450, 350);
        this.setVisible(true);

    }

    private void layoutComponents(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        this.setLayout(layout);
        constraints.insets = new Insets(5,5,5,5);
        constraints.anchor = GridBagConstraints.WEST;



        //fill the first column
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(this.accountNumberLabel, constraints);

        constraints.gridy = 1;
        this.add(this.accountTypeLabel, constraints);

        constraints.gridy = 2;
        this.add(this.currencyLabel, constraints);

        constraints.gridy = 3;
        this.add(this.amountLabel, constraints);

        constraints.gridy = 4;
        this.add(this.customerIdLabel, constraints);

        constraints.gridy = 5;
        this.add(this.passwordLabel, constraints);

        constraints.gridy = 6;
        this.add(this.confirmPasswordLabel, constraints);

        constraints.gridy = 7;
        this.add(this.saveButton, constraints);

        //fill the second column
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(this.accountNumberInput, constraints);

        constraints.gridy = 1;
        this.add(this.accountTypeCombo, constraints);

        constraints.gridy = 2;
        this.add(this.currencyCombo, constraints);

        constraints.gridy = 3;
        this.add(this.amountInput, constraints);

        constraints.gridy = 4;
        this.add(this.customerIdInput, constraints);

        constraints.gridy = 5;
        this.add(this.passwordInput, constraints);

        constraints.gridy = 6;
        this.add(this.confirmPasswordInput, constraints);

        constraints.gridy = 7;
        this.add(this.clearButton, constraints);
    }




    public JLabel getAccountNumberLabel() {
        return accountNumberLabel;
    }

    public void setAccountNumberLabel(JLabel accountNumberLabel) {
        this.accountNumberLabel = accountNumberLabel;
    }

    public JLabel getAccountTypeLabel() {
        return accountTypeLabel;
    }

    public void setAccountTypeLabel(JLabel accountTypeLabel) {
        this.accountTypeLabel = accountTypeLabel;
    }

    public JLabel getCurrencyLabel() {
        return currencyLabel;
    }

    public void setCurrencyLabel(JLabel currencyLabel) {
        this.currencyLabel = currencyLabel;
    }

    public JLabel getAmountLabel() {
        return amountLabel;
    }

    public void setAmountLabel(JLabel amountLabel) {
        this.amountLabel = amountLabel;
    }

    public JLabel getCustomerIdLabel() {
        return customerIdLabel;
    }

    public void setCustomerIdLabel(JLabel customerIdLabel) {
        this.customerIdLabel = customerIdLabel;
    }

    public JTextField getAccountNumberInput() {
        return accountNumberInput;
    }

    public void setAccountNumberInput(JTextField accountNumberInput) {
        this.accountNumberInput = accountNumberInput;
    }

    public JTextField getAmountInput() {
        return amountInput;
    }

    public void setAmountInput(JTextField amountInput) {
        this.amountInput = amountInput;
    }

    public JTextField getCustomerIdInput() {
        return customerIdInput;
    }

    public void setCustomerIdInput(JTextField customerIdInput) {
        this.customerIdInput = customerIdInput;
    }

    public JComboBox<AccountType> getAccountTypeCombo() {
        return accountTypeCombo;
    }

    public void setAccountTypeCombo(JComboBox<AccountType> accountTypeCombo) {
        this.accountTypeCombo = accountTypeCombo;
    }

    public JComboBox<String> getCurrencyCombo() {
        return currencyCombo;
    }

    public void setCurrencyCombo(JComboBox<String> currencyCombo) {
        this.currencyCombo = currencyCombo;
    }

    public JPasswordField getConfirmPasswordInput() {
        return confirmPasswordInput;
    }

    public void setConfirmPasswordInput(JPasswordField confirmPasswordInput) {
        this.confirmPasswordInput = confirmPasswordInput;
    }

    public JPasswordField getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(JPasswordField passwordInput) {
        this.passwordInput = passwordInput;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }
}
