package controller;

import dto.CustomerDto;
import dto.EmployeeDto;
import model.Customer;
import model.Employee;
import service.CustomerService;
import view.customer.CustomerCreatePage;

import javax.swing.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class CustomerCreateController {

    private CustomerCreatePage page;
    private CustomerService customerService;

    public CustomerCreateController(){
        this.page = new CustomerCreatePage();
        this.customerService = new CustomerService();
        this.page.getCreateBtn().addActionListener(e-> handleCreateBtnAction());
        this.page.getCancelBtn().addActionListener(e-> handleCancelBtnAction());

    }

    private void handleCancelBtnAction() {

    }

    private void handleCreateBtnAction() {
        CustomerDto customerDto = getCustomerInfo();
        Customer customer = this.customerService.createProcess(customerDto);
        this.page.dispose();
        JOptionPane.showMessageDialog(this.page, "Employee Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private CustomerDto getCustomerInfo(){
        String firstName = this.page.getFirstnameTextField().getText();
        String lastName = this.page.getLastnameTextField().getText();
       // Date dateOfBirth=  Date.parse( this.page.getDateOfBirthTextField().getText());
        String nrc = this.page.getNrcTextField().getText();
        String phone = this.page.getPhoneTextField().getText();
        String email = this.page.getEmailTextField().getText();
        String address = this.page.getAddressTextField().getText();
//        CustomerDto customerDto = new CustomerDto(firstName, lastName, dateOfBirth, nrc, phone, email,  address );
        return null;
        }
}
